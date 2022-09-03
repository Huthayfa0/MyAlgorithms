#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];}
    multiset<ll> m;m.insert(arr[0]);
    for(int i=1;i<n;i++){
        auto t=m.upper_bound(arr[i]);
        if(t!=m.end())m.erase(t);
        m.insert(arr[i]);
    }
    cout<<m.size();
    return 0;
}