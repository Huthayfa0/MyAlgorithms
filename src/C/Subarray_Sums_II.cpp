#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n,x;cin>>n>>x;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];}
    ll s=0,ans=0;
    map<ll,ll> m;
    m[0]=1;
    for(auto i:arr){
        s+=i;
        ans+=m[s-x];
        m[s]++;
    }
    cout<<ans;
    return 0;
}