#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
int main(){
    ll n;cin>>n;ll arr[n+6]={0};
    for(ll i=1;i<=6;i++)arr[i]=1;
    for(ll i=1;i<=n;i++){
        for(ll j=1;j<=min(i-1,6LL);j++){
            arr[i]+=arr[i-j];
            arr[i]%=MOD;
        }
    }
    cout<<arr[n];
    return 0;
}