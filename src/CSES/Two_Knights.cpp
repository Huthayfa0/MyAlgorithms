#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    for(ll i=1;i<=n;i++){
        ll ans=i*i*(i*i-1)/2;
        ans-=(i-4)*(4*i-6);
        ans-=10*(i-2);
        ans-=4;
        cout<<ans<<'\n';
    }
    return 0;
}