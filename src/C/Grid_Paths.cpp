#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
int main(){
    ll n;cin>>n;string arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    ll dp[n][n];for(ll i=0;i<n;i++)for(ll j=0;j<n;j++)dp[i][j]=0;
    dp[0][0]=arr[0][0]=='.';
    for(ll i=1;i<n;i++)if(arr[0][i]=='.')dp[0][i]=(dp[0][i]+dp[0][i-1])%MOD;
    for(ll i=1;i<n;i++){
        if(arr[i][0]=='.'){
            dp[i][0]=(dp[i][0]+dp[i-1][0])%MOD;
        }
        for(ll j=1;j<n;j++){
        if(arr[i][j]=='.'){
            dp[i][j]=(dp[i][j]+dp[i-1][j]+dp[i][j-1])%MOD;
        }
    }
    }
    cout<<dp[n-1][n-1];
    return 0;
}