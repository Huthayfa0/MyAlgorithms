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
    que.push(1);
    vis[1]=-1;
    while(!que.empty()){
        ll x=que.front();que.pop();
        for(auto y:adj[x]){
            if(!vis[y]){
                vis[y]=x;
                que.push(y);
            }
        }
    }
    if(!vis[n]){
        cout<<"IMPOSSIBLE";
        return 0;
    }
    stack<ll> stk;
    while(n!=-1){
        stk.push(n);
        n=vis[n];
    }
    cout<<stk.size()<<"\n";
    while(!stk.empty()){
        cout<<stk.top()<<" ";stk.pop();
    }
    return 0;
}