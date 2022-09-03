#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,x;cin>>n>>x;ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    sort(arr,arr+n);
    ll i=0,j=n-1,ans=0;
    while(i<=j){
        if(arr[i]+arr[j]<=x){
            i++;
        }
        j--;
        ans++;
    }
    cout<<ans;
    return 0;
}