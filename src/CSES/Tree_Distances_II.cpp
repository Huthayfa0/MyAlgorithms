#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MX 200005
ll n, sum[MX],ch[MX];
vector<ll> adj[MX];
void dfs(ll x,ll p){
    sum[x]=0;
    ch[x]=1;
    for(auto v:adj[x]){
        if(v==p)continue;
        dfs(v,x);
        sum[x]+=sum[v]+ch[v];
        ch[x]+=ch[v];
    }    
}
void dfs2(ll x,ll p){
    if(p!=0)  
        sum[x]=sum[p]+n-2*ch[x];
    for(auto v:adj[x]){
        if(v==p)continue;
        dfs2(v,x);
    }  
}
int main(){
    cin>>n;
    for(ll i=0;i<n-1;i++){
        ll x,y;cin>>x>>y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    dfs(1,0);
    dfs2(1,0);
    for(ll i=1;i<=n;i++)cout<<sum[i]<<" ";
    return 0;
}