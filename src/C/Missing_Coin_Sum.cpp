#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,s=1;cin>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];}
    sort(arr,arr+n);
    
    for(int i=0;i<n;i++){
        if(s<arr[i])break;
        s+=arr[i];
    }
    cout<<s;
    return 0;
}