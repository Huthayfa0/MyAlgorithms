#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n;cin>>n;
    map<ll,ll> m;
    vector<ll> arr[n];
    for(ll i=0;i<n;i++){
        ll x,y,z;cin>>x>>y>>z;
        arr[i]={x,y,z};
        m[x]++;m[y]++;
    }
    ll cnt=1;
    for(auto &p:m){
        p.second=cnt++;
    }
    vector<vector<pair<ll,ll>>> ma(cnt+1);
    for(auto &x:arr){
        ma[m[x[1]]].push_back({m[x[0]],x[2]});
    }
    ll dp[cnt+1]={0};
    dp[0]=0;
    for(ll i=1;i<=cnt;i++){
        dp[i]=dp[i-1];
        for(auto p:ma[i]){
            dp[i]=max(dp[i],dp[p.first-1]+p.second);
        }
    }
    cout<<dp[cnt];
    return 0;
}