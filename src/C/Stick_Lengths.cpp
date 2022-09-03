#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,s=0;cin>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];s+=arr[i];}
    sort(arr,arr+n);
    ll best=s-n*arr[0],cur=arr[0];
    for(int i=1;i<n;i++){
        cur+=arr[i];
        if(arr[i]!=arr[i-1]){
            best=min(best,(i+1)*arr[i]-cur+s-cur-(n-i-1)*arr[i]);
        }
    }
    cout<<best;
    return 0;
}