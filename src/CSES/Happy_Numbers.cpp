#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll dp[16][9];
map<ll,ll> arr[16][9];
set<ll> st,nn;
ll cal(ll x){
    vector<ll> v;
    while(x>0)v.push_back(x%10),x/=10;
    if(v.size()==17)return dp[15][8]+1;
    if(v.size()==0)return 0;
    if(v.size()==1)return dp[0][v[0]-1];
    ll ans=0;
    ans+=dp[v.size()-1][v.back()-1];
    ll cnt=v.back()*v.back();
    for(int i=v.size()-2;i>=0;i--){
        //ans+=st.count(cnt);
        for(int j=v[i];j<9;j++)
        for(auto c:arr[i][j]){
            if(st.count(c.first+cnt))ans-=c.second;
        }
        cnt+=v[i]*v[i];
    }
    return ans;
}
ll c(ll x){
    ll v=0;
    while(x>0)v+=(x%10)*(x%10),x/=10;
    return v;
}
int main(){
    st.insert(1);int cnt=0;
    for(int i=1;i<14000;i++){
        int j=i;
        nn.clear();
        while(!st.count(j)&&!nn.count(j)){
            nn.insert(j);
            j=c(j);
        }
        if(st.count(j)){
            st.insert(i);
            //cout<<++cnt<<" "<<i<<"\n";
        }
    }
    for(int i=0;i<9;i++){
        arr[0][i][(i+1)*(i+1)]=1;
    }
    for(int i=1;i<16;i++){
        for(int j=0;j<9;j++){
            arr[i][j][(j+1)*(j+1)]=1;
             for(int v=1;v<=i;v++)
           for(int k=0;k<9;k++){
                for(auto c:arr[i-v][k]){
                    arr[i][j][c.first+(j+1)*(j+1)]+=c.second;
                }
           } 
        }
    }
    for(int i=0;i<16;i++){
        for(int j=0;j<9;j++){
            for(auto c:arr[i][j]){
                if(st.count(c.first))dp[i][j]+=c.second;
            }
        }
    }
    for(int i=0;i<16;i++){
        if(i!=0){
            dp[i][0]+=dp[i-1][8];
        }
        for(int j=1;j<9;j++){
            dp[i][j]+=dp[i][j-1];
        }
    }

    ll x,y;cin>>x>>y;
    cout<<cal(y)-cal(x-1);
}
