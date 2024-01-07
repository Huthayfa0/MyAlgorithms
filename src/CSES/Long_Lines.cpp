#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,h0,a,c,q;cin>>n>>h0>>a>>c>>q;
    ll arr[n];arr[0]=h0;for(ll i=1;i<n;i++){arr[i]=(arr[i-1]*a%q+c)%q;}
    vector<ll> dd;
    dd.push_back(arr[0]);  
    ll ans=0;
    for(ll i=1;i<n;i++){
        ans+=ll(dd.size());
        while((!dd.empty())&&arr[i]>dd.back())dd.pop_back();
        dd.push_back(arr[i]);
    }
    cout<<ans;
}
