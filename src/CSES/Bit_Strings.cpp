#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007LL
ll fastpow(ll x,ll y){
    ll ans=1;
    while(y>0){
        if(y&1)ans=ans*x%MOD;
        x=x*x%MOD;
        y>>=1;
    }
    return ans;
}
int main(){
    ll n;cin>>n;
    cout<<fastpow(2,n);
    return 0;
}