#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    string x,y;cin>>x>>y;
    ll n=x.size(),m=y.size();
    ll dp[n+1][m+1]={0};
    for(ll i=1;i<=m;i++){
        dp[0][i]=i;
    }
    for(ll i=1;i<=n;i++){
        dp[i][0]=i;
    }
    for(ll i=1;i<=n;i++){
        for(ll j=1;j<=m;j++){
            dp[i][j]=dp[i][j-1]+1;
            dp[i][j]=min(dp[i][j],dp[i-1][j]+1);
            dp[i][j]=min(dp[i][j],dp[i-1][j-1]+(x[i-1]!=y[j-1]));
        }
    }
    cout<<dp[n][m];
    return 0;
}