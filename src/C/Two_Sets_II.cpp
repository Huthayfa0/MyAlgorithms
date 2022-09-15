#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n;cin>>n;
    ll MX=n*(n+1)/2;
    if(MX%2){
        cout<<0;
        return 0;
    }
    ll x=MOD-2;
    ll v=1,a=2;
    while(x>0){
        if(x&1)v=(v*a)%MOD;
        a=(a*a)%MOD;
        x>>=1;
    }
    MX/=2;
    ll dp[n+1][MX+1];memset(dp,0,sizeof(dp));
    dp[0][0]=1;
    for(ll i=1;i<=n;i++){
        for(ll j=0;j<=MX;j++){
            dp[i][j]=dp[i-1][j];
            if(j-i>=0){
                dp[i][j]=(dp[i][j]+dp[i-1][j-i])%MOD;
            }
        }
    }    
    cout<<((dp[n][MX]*v)%MOD);
    return 0;
}