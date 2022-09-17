#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n;cin>>n;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];}
    vector<ll> dd;
    dd.push_back(arr[0]);
    for(ll i=1;i<n;i++){
        if(arr[i]>dd.back()){
            dd.push_back(arr[i]);
        }else{
            ll x=lower_bound(dd.begin(),dd.end(),arr[i])-dd.begin();
            dd[x]=arr[i];
        }
    }
    cout<<dd.size();
    return 0;
}