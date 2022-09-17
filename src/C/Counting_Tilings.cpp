#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n,m;cin>>n>>m;
    if(n>m)swap(n,m);
    vector<ll> arr[1<<n];
    for(ll i=0;i<1<<n;i++){
        for(ll j=0;j<1<<n;j++){
            while(j&i){
                j+=((j&i)&(-(j&i)));
            }
            if(j>=1<<n)continue;
            bool an=true;
            ll cnt=0;
            ll x=j^i;
            for(ll k=0;k<n;k++){
                if(x&(1<<k)){
                    an&=(cnt%2==0);
                    cnt=0;
                }else{
                    cnt++;
                }
            }
            an&=(cnt%2==0);
            if(an)arr[i].push_back(j);
        }
    }
    ll dp[m][1<<n];memset(dp,0,sizeof(dp));
    for(auto x:arr[0])dp[0][x]=1;
    for(ll i=0;i<m-1;i++){
        for(ll j=0;j<1<<n;j++){
            if(dp[i][j]!=0){
            for(auto x:arr[j]){
                dp[i+1][x]=(dp[i+1][x]+dp[i][j])%MOD;
            }
            }
        }
    }
    cout<<dp[m-1][0];
    return 0;
}