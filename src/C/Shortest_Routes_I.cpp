#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
 
int main(){
    ll n,m;cin>>n>>m;
    vector<pair<ll,ll>> adj[n+1];
    while(m--){
        ll x,y,w;cin>>x>>y>>w;
        adj[x].push_back({y,w});
        //adj[y].push_back({x,w});
    }
    ll cost[n+1];bool proc[n+1]={0};for(ll i=0;i<=n;i++)cost[i]=numeric_limits<ll>::max()/2;
    cost[1]=0;
    priority_queue<pair<ll,ll>> pr;
    pr.push({0,1});
    while(!pr.empty()){
        auto x=pr.top();pr.pop();
        if(proc[x.second])continue;
        proc[x.second]=1;
        for( auto a:adj[x.second]){
            if(a.second+cost[x.second]<cost[a.first]){
                cost[a.first]=a.second+cost[x.second];
                pr.push({-cost[a.first],a.first});
            }
        }
    }
    for(ll i=1;i<=n;i++){
        cout<<cost[i]<<" ";
    }
    return 0;
}