#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n,m;cin>>n>>m;
    string arr[n];
    for(ll i=0;i<n;i++)cin>>arr[i];
    char vis[n][m];
    ll cost[n][m];
    memset(vis,0,sizeof(vis));
    memset(cost,0,sizeof(cost));

    queue<pair<pair<ll,ll>,ll>> que;
    ll ans=0;
    ll si,sj;
    for(ll i=0;i<n;i++){
        for(ll j=0;j<m;j++){
            if(arr[i][j]=='A'){
                si=i;sj=j;
            }
            if(arr[i][j]=='M'){
                que.push({{i,j},1});
            }
        }
    }
    
    while(!que.empty()){
        auto x=que.front();que.pop();
        ll i=x.first.first,j=x.first.second;ll c=x.second;
        if(cost[i][j]||arr[i][j]=='#')continue;
        cost[i][j]=c;
        if(i>0){
            que.push({{i-1,j},c+1});
        }
        if(j>0){
            que.push({{i,j-1},c+1});
        }
        if(i<n-1){
            que.push({{i+1,j},c+1});
        }
        if(j<m-1){
            que.push({{i,j+1},c+1});
        }
    }
    ll fi=-1,fj=-1;
    que.push({{si,sj},0});
    vis[si][sj]='S';
    while(!que.empty()){
        auto x=que.front();que.pop();
        ll i=x.first.first,j=x.first.second;ll c=x.second;
        if((cost[i][j]!=0&&c>=cost[i][j]-1)||arr[i][j]=='#')continue;
        if(i>0){
            if(!vis[i-1][j]){
                vis[i-1][j]='U';
                que.push({{i-1,j},c+1});
            
            }
        }
        if(j>0){
            if(!vis[i][j-1]){
                vis[i][j-1]='L';
            que.push({{i,j-1},c+1});}
        }
        if(i<n-1){
            if(!vis[i+1][j]){
                vis[i+1][j]='D';
            que.push({{i+1,j},c+1});}
        }
        if(j<m-1){
            if(!vis[i][j+1]){
                vis[i][j+1]='R';
            que.push({{i,j+1},c+1});}
        }
        if(i==0||j==0||i==n-1||j==m-1){
            fi=i;fj=j;
            break;
        }
    }
    if(fi!=-1&&fj!=-1&&vis[fi][fj]){
        cout<<"YES"<<"\n";
        stack<char> stk;
        ll i=fi,j=fj;
        while(vis[i][j]!='S'){
            stk.push(vis[i][j]);
            switch(vis[i][j]){
                case 'U':i++;break;
                case 'D':i--;break;
                case 'L':j++;break;
                case 'R':j--;break;
            }
        }
        cout<<stk.size()<<"\n";
        while(!stk.empty()){
            cout<<stk.top();stk.pop();
        }
    }else{
        cout<<"NO"<<"\n";
    }
    return 0;
}