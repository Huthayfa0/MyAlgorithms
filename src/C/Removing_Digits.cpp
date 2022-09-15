#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
int main(){
    ll n;cin>>n;ll arr[n+1];fill_n(arr,n+1,numeric_limits<ll>::max());
    arr[0]=0;
    for(ll i=1;i<=n;i++){
        ll x=i;
        while(x>0){
            if(x%10!=0)
            arr[i]=min(arr[i],arr[i-(x%10)]+1);
            x/=10;
        }
    }
    cout<<arr[n];
    return 0;
}