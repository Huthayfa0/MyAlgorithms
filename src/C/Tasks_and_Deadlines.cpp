#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n;cin>>n;
    pair<ll,ll> arr[n];for(ll i=0;i<n;i++){cin>>arr[i].first>>arr[i].second;arr[i].second*=-1;}
    sort(arr,arr+n);
    ll ans=0;
    ll cur=0;
    for(ll i=0;i<n;i++){
        cur+=arr[i].first;
        ans+=-arr[i].second-cur;
    }
    cout<<ans;
    return 0;
}