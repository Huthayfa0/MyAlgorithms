#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];}
    ll ans=1,cur=0;
    map<ll,ll> m;m[arr[0]]=0;
    for(int i=1;i<n;i++){
        if(m.count(arr[i])){
            cur=max(cur,m[arr[i]]+1);
            m[arr[i]]=i;
        }else{
            m[arr[i]]=i;
        }
        ans=max(ans,i-cur+1);
    }
    cout<<ans;
    return 0;
}