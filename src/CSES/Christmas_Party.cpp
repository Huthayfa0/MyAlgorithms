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
    ll arr[n+1];
    arr[0]=1;arr[1]=0;
    for(ll i=2;i<=n;i++){
        arr[i]=(arr[i-1]+arr[i-2]%MOD)*(i-1)%MOD;
    }
    cout<<arr[n];
    return 0;
}