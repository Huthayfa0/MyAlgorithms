#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n,x;cin>>n>>x;
    pair<ll,ll> arr[n];for(ll i=0;i<n;i++){cin>>arr[i].first;arr[i].second=i+1;}
    sort(arr,arr+n);
    for (ll kk=0;kk<n;kk++)
    for(ll i=kk+1;i<n;i++){
        ll j=i+1,k=n-1,s=x-arr[i].first-arr[kk].first;
        if(s<0)continue;
        while(j<k){
            if(arr[j].first+arr[k].first>s){
                k--;
            }else if(arr[j].first+arr[k].first<s){
                j++;
            }else{
                i=arr[i].second;
                j=arr[j].second;
                k=arr[k].second;
                kk=arr[kk].second;

                cout<<kk<<" "<<i<<" "<<j<<" "<<k;
                return 0;
            }
        }
        }
        cout<<"IMPOSSIBLE";
    return 0;
}