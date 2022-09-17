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
    queue<ll> que;
    for(ll i=1;i<=n;i++){
        if(vis[i])continue;
    que.push(i);
    vis[i]=1;
    while(!que.empty()){
        ll x=que.front();que.pop();
        for(auto y:adj[x]){
            if(!vis[y]){
                vis[y]=3-vis[x];
                que.push(y);
            }else if(vis[y]==vis[x]){
                cout<<"IMPOSSIBLE";
                return 0;
            }
        }
    }}
    for(ll i=1;i<=n;i++){
        cout<<vis[i]<<" ";
    }
    
    return 0;
}