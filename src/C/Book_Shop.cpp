#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,x;cin>>n>>x;ll dp[x+1]={0};
    ll arr[n],pages[n];for(ll i=0;i<n;i++)cin>>arr[i];for(ll i=0;i<n;i++)cin>>pages[i];
    dp[0]=0;
    for(ll j=0;j<n;j++){
        for(ll i=x;i>=0;i--){
            if(i-arr[j]>=0){
                dp[i]=max(dp[i],dp[i-arr[j]]+pages[j]);
            }
        }
    }
    cout<<dp[x];
    return 0;
}