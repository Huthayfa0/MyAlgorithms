#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;pair<ll,ll> arr[n];for(int i=0;i<n;i++){cin>>arr[i].second>>arr[i].first;}
    sort(arr,arr+n);
    set<ll> s;
    ll best=1;
    ll cur=arr[0].first;
    for(int i=1;i<n;i++){
        if(arr[i].second>=cur){
            cur=arr[i].first;
            best++;
        }
    }
    cout<<best;
    return 0;
}