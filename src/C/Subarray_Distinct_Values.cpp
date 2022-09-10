#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll sum(ll x){
    return x*(x+1)/2;
}
int main(){
    ll n,x;cin>>n>>x;
    ll arr[n];for(ll i=0;i<n;i++){cin>>arr[i];}
    ll i=0,j=0,ans=0,k=0;
    map<ll,ll> m;
    while(j<n){
        if(m[arr[j]]==0){
            k++;
        }
        m[arr[j]]++;
        if(k>x){
            while(k>x){
                if(m[arr[i]]==1){
                    k--;
                }
                m[arr[i]]--;
                i++;
            }
        }
        ans+=j-i+1;
        j++;
    }
    cout<<ans;
    return 0;
}