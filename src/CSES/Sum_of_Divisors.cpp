#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MX 1000005
#define MOD 1000000007
ll sieve[MX];
ll fpow(ll x,ll y,ll m=MOD){
    ll ans=1;
    while(y>0){
        if(y&1)ans=ans*x%m;
        y>>=1;
        x=x*x%m;
 
    }
    return ans;
}
ll inv2=fpow(2,MOD-2);
ll pfac(ll x){
    ll ans=1;
    while(x>1){
        ll v=sieve[x],cnt=0;
        while(x%v==0){
            x/=v;cnt++;
        }
        ans*=cnt+1;
    }
    return ans;
}
ll sum(ll a, ll b){
    return (((a+b)%MOD)*((b-a+1)%MOD)%MOD)*inv2%MOD;
}
int main(){
    ll n;cin>>n;
    ll s=0;
    ll cur=1;
    while(cur<=n){
        ll x=n/cur;
        ll nx=n/x;
        s+=x*sum(cur,nx)%MOD;
        s%=MOD;
        cur=1+nx;
 
    }
    cout<<s;
    return 0;
}