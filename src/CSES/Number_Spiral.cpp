#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll t;cin>>t;
    while(t--){
        ll x,y;cin>>x>>y;
        if(max(x,y)&1)swap(x,y);
        ll ans=max(x,y)*max(x,y);
        ans-=y-1+max(x,y)-x;
        cout<<ans<<'\n';
    }
    return 0;
}