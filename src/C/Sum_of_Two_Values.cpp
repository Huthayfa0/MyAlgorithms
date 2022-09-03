#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,x;cin>>n>>x;pair<ll,ll> arr[n];for(int i=0;i<n;i++){cin>>arr[i].first;arr[i].second=i+1;}
    sort(arr,arr+n);
    ll i=0,j=n-1;
    while(i<j){
        if(arr[i].first+arr[j].first>x)j--;
        else if(arr[i].first+arr[j].first<x)i++;
        else break;
    }
    if(i!=j&&arr[i].first+arr[j].first==x){if(arr[i].second>arr[j].second)swap(i,j);
        cout<<arr[i].second<<" "<<arr[j].second;
    }else
        cout<<"IMPOSSIBLE";
    return 0;
}