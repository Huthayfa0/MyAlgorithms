#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    if((n*(n+1)/2)&1){
        cout<<"NO";
        return 0;
    }
    cout<<"YES"<<'\n';
    vector<ll> a;
    ll sum=n*(n+1)/4;
    ll i=n;
    while(sum>i){
        sum-=i;
        i--;
    }
    cout<<n-i+1<<"\n";
    for(ll k=i+1;k<=n;k++)cout<<k<<" ";
    cout<<sum<<"\n";

    cout<<i-1<<'\n';
    for(ll k=1;k<=i;k++){
        if(k!=sum){
            cout<<k<<" ";
        }
    }
    return 0;
}