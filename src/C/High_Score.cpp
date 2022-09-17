#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
 
int main(){
    ll n,m;cin>>n>>m;
    ll cost[n+1];
    for(ll i=0;i<=n;i++){
        cost[i]=-numeric_limits<ll>::max()/2;
    }
    cost[1]=0;
    vector<tuple<ll,ll,ll>> edges;
    while(m--){
        ll x,y,w;cin>>x>>y>>w;
        edges.push_back({x,y,w});
    }
    for(ll i=0;i<n-1;i++){
        for(auto p:edges){
            ll x,y,w;
            tie(x,y,w)=p;
            if(cost[x]!=-numeric_limits<ll>::max()/2)
            cost[y]=max(cost[y],cost[x]+w);
        }
    }
    ll v=cost[n];
    ll c[n+1];
    copy(cost,cost+n+1,c);
    for(auto p:edges){
        ll x,y,w;
        tie(x,y,w)=p;
        if(cost[x]!=-numeric_limits<ll>::max()/2)
        cost[y]=max(cost[y],cost[x]+w);
    }
    for(ll i=0;i<=n;i++){
        if(c[i]<cost[i])cost[i]=numeric_limits<ll>::max()/2;
    }
    for(ll i=0;i<n-1;i++){
        for(auto p:edges){
            ll x,y,w;
            tie(x,y,w)=p;
            if(cost[x]!=-numeric_limits<ll>::max()/2)
            cost[y]=max(cost[y],cost[x]+w);
        }
    }
    if(v!=cost[n]){
        cout<<-1;
    }else
    cout<<cost[n];
    return 0;
}