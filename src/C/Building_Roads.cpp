#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n,m;cin>>n>>m;
    vector<ll> adj[n+1];
    while(m--){
        ll x,y;cin>>x>>y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    ll vis[n+1]={0};
    for(ll i=1;i<=n;i++){
        if(vis[i])continue;
        stack<ll> stk;
        stk.push(i);
        while(!stk.empty()){
            ll x=stk.top();stk.pop();
            if(vis[x])continue;
            vis[x]=i;
            for(auto y:adj[x]){
                stk.push(y);
            }
        }
    }
    vis[0]=1;
    sort(vis,vis+n+1);
    auto it=unique(vis,vis+n+1);
    n=it-vis;
    cout<<n-1<<"\n";
    for(ll i=1;i<n;i++){
        cout<<vis[i-1]<<" "<<vis[i]<<"\n";
    }

    return 0;
}