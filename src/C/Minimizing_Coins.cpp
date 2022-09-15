#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,x;cin>>n>>x;ll dp[x+1];fill_n(dp,x+1,numeric_limits<ll>::max());
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    dp[0]=0;
    for(ll i=1;i<=x;i++){
        for(ll j=0;j<n;j++){
            if(i-arr[j]>=0&&dp[i-arr[j]]!=numeric_limits<ll>::max()){
                dp[i]=min(dp[i],dp[i-arr[j]]+1);
            }
        }
    }
    if(dp[x]==numeric_limits<ll>::max())dp[x]=-1;
    cout<<dp[x];
    return 0;
}