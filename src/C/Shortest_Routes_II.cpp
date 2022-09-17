#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
 
int main(){
    ll n,m,q;cin>>n>>m>>q;
    ll dp[n+1][n+1];
    fill(*dp,*dp+(n+1)*(n+1),numeric_limits<ll>::max()/2);
    for(ll i=0;i<=n;i++)dp[i][i]=0;
    while(m--){
        ll x,y,w;cin>>x>>y>>w;
        dp[x][y]=min(dp[x][y],w);
        dp[y][x]=min(dp[y][x],w);
    }
    for(ll i=1;i<=n;i++)for(ll j=1;j<=n;j++)for(ll k=1;k<=n;k++)dp[j][k]=min(dp[j][k],dp[j][i]+dp[i][k]);
    while(q--){
        ll x,y;cin>>x>>y;
        if(numeric_limits<ll>::max()/2>dp[x][y]){
            cout<<dp[x][y]<<"\n";
        }else{
            cout<<"-1\n";
        }
    }
    return 0;
}