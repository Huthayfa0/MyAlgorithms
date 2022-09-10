#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
bool valid(ll* arr,ll n,ll x,ll t){
    for(ll i=0;i<n;i++){
        t-=x/arr[i];
        if(t<=0)return true;
    }
    return false;
}
int main(){
    ll n,t;cin>>n>>t;
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    sort(arr,arr+n);
   
    ll MX=t*arr[0];
    ll k=0;
    for(ll i=MX;i>=1;i/=2){
        while(!valid(arr,n,i+k,t))k+=i;
    }
    cout<<k+1;
    return 0;
}