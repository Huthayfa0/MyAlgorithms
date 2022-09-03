#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;pair<ll,ll> arr[n];for(int i=0;i<n;i++){cin>>arr[i].first;arr[i].second=i+1;}
    sort(arr,arr+n);
    ll ans=1,cur=0;
    for(int i=0;i<n;i++){
        if(arr[i].second<cur){ans++;cur=0;}
        cur=arr[i].second;
    }
    cout<<ans;
    return 0;
}