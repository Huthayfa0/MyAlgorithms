#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,m;cin>>n>>m;
    ll dp[n+1][m+1]={0};
    dp[0][0]=0;
    dp[1][1]=0;
    for(ll i=1;i<=n;i++){
        for(ll j=1;j<=m;j++){
            ll x=1;
            dp[i][j]=numeric_limits<ll>::max();
            while(x<=max(i,j)){
                if(i-x>0){
                    dp[i][j]=min(dp[i][j],dp[i-x][j]+dp[x][j]+1);
                }
                if(j-x>0){
                    dp[i][j]=min(dp[i][j],dp[i][j-x]+dp[i][x]+1);
                }
                if(i==x&&j==x){
                    dp[i][j]=0;
                }
                x++;
            }
        }
    }
    cout<<dp[n][m];
    return 0;
}