#include<bits/stdc++.h>
using namespace std;
int main(){
    long long n,ans=1;cin>>n;long long arr[n];
    for(int i=0;i<n;i++)cin>>arr[i];
    sort(arr,arr+n);
    for(int i=1;i<n;i++)ans+=arr[i]!=arr[i-1];
    cout<<ans;
    return 0;
}