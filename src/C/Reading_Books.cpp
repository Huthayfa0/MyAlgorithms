#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n;cin>>n;
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    ll mx=0;
    ll s=0;for(ll i=0;i<n;i++){s+=arr[i];mx=max(mx,arr[i]);}
    cout<<max(2*mx,s);
    return 0;
}