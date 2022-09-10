#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    pair<pair<ll,ll>,ll> arr[n];for(ll i=0;i<n;i++){
        cin>>arr[i].first.first>>arr[i].first.second;arr[i].second=i;
    }
    sort(arr,arr+n);
    ll ans[n];
    multimap<ll,ll> m;
    ll count=0;
    for(ll i=0;i<n;i++){
        auto p=arr[i].first;
        auto it=m.lower_bound(-p.first);
        if(it==m.end()){
            count++;
            ans[arr[i].second]=count;
            m.insert({-p.second-1,count});
        }else{
            ans[arr[i].second]=(*it).second;
            m.erase(it);
            m.insert({-p.second-1,ans[arr[i].second]});
        }
    }
    cout<<count<<"\n";
    for(ll i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }
    return 0;
}