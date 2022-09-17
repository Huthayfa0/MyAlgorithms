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
    ll level[n+1]={0};
    queue<ll> que;
    for(ll i=1;i<=n;i++){
        if(vis[i])continue;
        que.push(i);
        vis[i]=-1;
        level[i]=1;
        while(!que.empty()){
            ll x=que.front();que.pop();
            for(auto y:adj[x]){
                if(!vis[y]){
                    vis[y]=x;
                    level[y]=level[x]+1;
                    que.push(y);
                }else if(vis[y]!=-1&&vis[x]!=y){
                    list<ll> vec;
                    if(level[y]>level[x]){
                        swap(y,x);
                    }
                    while(level[x]>level[y]){
                        vec.push_front(x);x=vis[x];
                    }
                    while(y!=x){
                        if(y!=-1){
                        vec.push_back(y);y=vis[y];}
                        if(x!=-1){
                        vec.push_front(x);x=vis[x];}
                    }
                    if(y!=-1)
                    vec.push_back(y);
                    if(x!=-1)
                    vec.push_front(x);
                    cout<<vec.size()<<"\n";
                    for(auto x:vec)cout<<x<<" ";
                    return 0;
                }
            }
        }
    }
    cout<<"IMPOSSIBLE";
    return 0;
}