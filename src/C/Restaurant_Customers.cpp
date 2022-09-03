#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;pair<ll,ll> arr[n];for(int i=0;i<n;i++){cin>>arr[i].first>>arr[i].second;arr[i].second++;}
    sort(arr,arr+n);
    set<ll> s;
    ll best=1;
    s.insert(arr[0].second);
    for(int i=1;i<n;i++){
        if(arr[i].first!=arr[i-1].first){
            s.erase(s.begin(),s.upper_bound(arr[i].first));
        }
        s.insert(arr[i].second);
        best=max(best,ll(s.size()));
    }
    cout<<best;
    return 0;
}