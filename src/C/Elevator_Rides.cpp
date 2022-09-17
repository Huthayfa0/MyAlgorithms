#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n,v;cin>>n>>v;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];}
    pair<ll,ll> dp[1<<n];
    dp[0]={1,0};
    for(ll i=1;i<1<<n;i++){
        dp[i]={n,0};
        for(ll j=0;j<n;j++){
            if(i&(1<<j)){
                auto x=dp[i^(1<<j)];
                x.first+=(x.second+arr[j]>v);
                x.second+=arr[j];
                if(x.second>v){
                    x.second=arr[j];
                }
                dp[i]=min(dp[i],x);
            }
        }
    }
    cout<<dp[(1<<n)-1].first;
    return 0;
}