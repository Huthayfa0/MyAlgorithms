#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    ll arr[n],sum[n];
    for(ll i=0;i<n;i++){cin>>arr[i];sum[i]=arr[i]+(i!=0?sum[i-1]:0);}
    ll dp[n][n];
    for(ll i=0;i<n;i++)dp[0][i]=arr[i];
    for(ll i=1;i<n;i++){
        for(ll j=0;j<n-i;j++){
            dp[i][j]=sum[i+j]-(j!=0?sum[j-1]:0)-min(dp[i-1][j],dp[i-1][j+1]);
        }
    }
    cout<<dp[n-1][0];
    return 0;
}