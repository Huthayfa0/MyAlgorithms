#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n,x;cin>>n>>x;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];}
    ll s=0,i=0,j=0,ans=s==x;
    while(j<n){
        if(s>x){
            s-=arr[i];
            i++;
        }else if(s<x){
            s+=arr[j];
            j++;
        }else{
            ans++;
            s-=arr[i];
            i++;
        }
    }
    while(i<n){
        if(s>x){
            s-=arr[i];
            i++;
        }else if(s<x){
            break;
        }else{
            ans++;
            s-=arr[i];
            i++;
        }
    }
    cout<<ans;
    return 0;
}