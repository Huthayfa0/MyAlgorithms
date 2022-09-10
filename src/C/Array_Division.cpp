#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
bool valid(ll* arr,ll n,ll x,ll t){
    ll tmp=0;
    ll added=0;
    for(ll i=0;i<n;i++){
        if(arr[i]>x)return false;
        if(arr[i]+tmp>x){
            tmp=arr[i];
            t--;
        }else{
            if(tmp!=0)added++;
            tmp+=arr[i];
        }
    }
    if(tmp)t--;
    if(t<0)return false;
    return t<=added;
}
int main(){
    ll n,t;cin>>n>>t;ll s=0;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];s+=arr[i];}
    ll MX=s;
    ll k=0;
    for(ll i=MX;i>=1;i/=2){
        while(!valid(arr,n,i+k,t))k+=i;
    }
    cout<<k+1;
    return 0;
}