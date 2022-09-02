#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,x;cin>>n;
    ll ans=n*(n+1)/2;n--;
    while(n--){
        cin>>x;ans-=x;
    }
    cout<<ans<<'\n';
    return 0;
}