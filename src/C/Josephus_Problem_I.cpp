#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;ll arr[n],next[n];for(int i=0;i<n;i++){arr[i]=i+1;next[i]=(i+1)%n;}
    ll cur=0;
    for(int i=0;i<n;i++){
        cout<<arr[next[cur]]<<" ";
        ll v=next[next[cur]];
        next[cur]=v;
        cur=v;
    }
    return 0;
}