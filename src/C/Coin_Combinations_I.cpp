#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
int main(){
    ll n,x;cin>>n>>x;ll dp[x+1]={0};
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    dp[0]=1;
    for(ll i=1;i<=x;i++){
        for(ll j=0;j<n;j++){
            if(i-arr[j]>=0){
                dp[i]+=dp[i-arr[j]];
                dp[i]%=MOD;
            }
        }
    }
    cout<<dp[x];
    return 0;
}