#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
void insert(ll *BIT,ll MX,ll i,ll x){
    while(i<MX){
        BIT[i]+=x;
        i+=i&-i;
    }
}
ll sum(ll *BIT,ll MX,ll i){
    ll ans=0;
    while(i>0){
        ans+=BIT[i];
        i-=i&-i;
    }
    return ans;
}
int main(){
    ll n,k;cin>>n>>k;
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    set<ll> st;for(ll i=0;i<n;i++)st.insert(arr[i]);
    ll cnt=0;
    map<ll,ll> m,b;
    for(auto x:st){m[x]=++cnt;b[cnt]=x;}
    ll MX=cnt+5;
    ll BIT[MX]={0};
    for(ll i=0;i<k-1;i++)insert(BIT,MX,m[arr[i]],1);
    for(ll i=k-1;i<n;i++){
        insert(BIT,MX,m[arr[i]],1);
        ll v1=cnt,v2=cnt;
        for(ll j=MX;j>=1;j/=2)while(v1-j>0&&sum(BIT,MX,v1-j)>=(k/2+1)){v1-=j;}
        if(k%2==0){
            for(ll j=MX;j>=1;j/=2)while(v2-j>0&sum(BIT,MX,v2-j)>=k/2)v2-=j;
            v1=min(v2,v1);
        }
        cout<<b[v1]<<" ";
        insert(BIT,MX,m[arr[i-k+1]],-1);
    }
}