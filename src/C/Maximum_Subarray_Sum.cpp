#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];}
    ll sum=arr[0],ans=arr[0];
    for(int i=1;i<n;i++){
        sum=max(sum+arr[i],arr[i]);
        ans=max(ans,sum);
    }
    cout<<ans;
    return 0;
}