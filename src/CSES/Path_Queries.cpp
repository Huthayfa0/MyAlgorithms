#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MX (1<<20)
ll n,q,tree[2*MX],cur=1,res[MX][2],lazy[2*MX],sum[MX];
vector<ll> adj[MX];
 
void dfs(ll x,ll p){
    res[x][0]=cur++;
    for(auto v:adj[x]){
        if(v!=p){
            sum[v]+=sum[x];
            dfs(v,x);
        }
    }
    res[x][1]=cur-1;
}
void pull(ll i){
    tree[i]=tree[2*i]+tree[2*i+1];
}
void push(ll i){
    tree[2*i]+=lazy[i];
    tree[2*i+1]+=lazy[i];
    lazy[2*i]+=lazy[i];
    lazy[2*i+1]+=lazy[i];
    lazy[i]=0;
}
void add(ll i,ll s,ll e,ll x,ll l=1,ll r=MX){
    if(e<l||r<s)return;
    if(s<=l&&r<=e){
        tree[i]+=x;
        lazy[i]+=x;
    }else{
        ll m=(r+l)/2;
        push(i);
        add(i*2,s,e,x,l,m);
        add(i*2+1,s,e,x,m+1,r);
        pull(i);
    }
}
ll quer(ll i,ll s,ll e,ll l=1,ll r=MX){
    if(e<l||r<s)return 0;
    if(s<=l&&r<=e){
        return tree[i];
    }else{
        ll m=(r+l)/2;
        push(i);
        ll v=quer(i*2,s,e,l,m)+quer(i*2+1,s,e,m+1,r);
        pull(i);
        return v;
    }
}
 
int main(){
    cin>>n>>q;
    ll arr[n+1];
    for(ll i=1;i<=n;i++){cin>>arr[i];
    sum[i]=arr[i];
    }
    for(ll i=2;i<=n;i++){
        ll x,y;
        cin>>x>>y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    dfs(1,0);
    for(ll i=1;i<=n;i++){
        add(1,res[i][0],res[i][0],sum[i]);
    }
 
    while(q--){
        ll op,a,b;
        cin>>op;
        if(op==1){
            cin>>a>>b;
            add(1,res[a][0],res[a][1],b-arr[a]);
            arr[a]=b;
        }
        if(op==2){
            cin>>a;
            cout<<quer(1,res[a][0],res[a][0])<<"\n";
        }
 
 
    }
 
 
    return 0;
}