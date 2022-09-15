#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,k;cin>>n>>k;
    pair<ll,ll> arr[n];for(ll i=0;i<n;i++){
        cin>>arr[i].second>>arr[i].first;
    }
    sort(arr,arr+n);
    multiset<ll> m;
    for(ll i=0;i<k;i++){
        m.insert(0);
    }
    ll count=0;
    for(ll i=0;i<n;i++){
        auto &p=arr[i];
        auto it=m.lower_bound(-p.second);
        if(it!=m.end()){
            count++;
            m.erase(it);
            m.insert(-p.first);
        }
    }
    cout<<count<<"\n";
    return 0;
}