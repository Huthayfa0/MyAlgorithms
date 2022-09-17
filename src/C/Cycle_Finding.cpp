#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
 
int main(){
    ll n,m;cin>>n>>m;
    ll cost[n+1]={0},parent[n+1]={0};
    vector<tuple<ll,ll,ll>> edges;
    while(m--){
        ll x,y,w;cin>>x>>y>>w;
        edges.push_back({x,y,w});
    }
    ll f=0;
    for(ll i=0;i<n;i++){
        f=0;
        for(auto p:edges){
            ll x,y,w;
            tie(x,y,w)=p;
            if(cost[y]>cost[x]+w){
                cost[y]=cost[x]+w;
                parent[y]=x;
                f=y;
            }
        }
    }
    
    if(f){
        cout<<"YES\n";
        for(ll i=0;i<n+1;i++)f=parent[f];
        ll v=f;
        cout<<v<<" ";
        v=parent[v];

        stack<ll> stk;
        while(v!=f){
            stk.push(v);
            v=parent[v];
        }
        while(stk.size()){
            cout<<stk.top()<<" ";
            stk.pop();
        }
        cout<<v;
        return 0;
    }
    cout<<"NO";
    return 0;
}