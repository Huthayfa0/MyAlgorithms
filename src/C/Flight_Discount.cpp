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
    ll cost1[n+1],cost2[n+1];bool proc1[n+1]={0},proc2[n+1]={0};for(ll i=0;i<=n;i++)cost1[i]=cost2[i]=numeric_limits<ll>::max()/2;
    cost1[1]=0;cost2[1]=0;
    priority_queue<tuple<ll,ll,ll>> pr;
    pr.push({0,1,0});
    while(!pr.empty()){
        ll w,x,t;
        tie(w,x,t)=pr.top();pr.pop();
        if(t){
            if(proc2[x])continue;
            proc2[x]=1;
            for(auto p:adj[x]){
                if(cost2[x]+p.second<cost2[p.first]){
                    cost2[p.first]=cost2[x]+p.second;
                    pr.push({-cost2[p.first],p.first,1});
                }
            }
        }else{
            if(proc1[x])continue;
            proc1[x]=1;
            for(auto p:adj[x]){
                if(cost1[x]+p.second<cost1[p.first]){
                    cost1[p.first]=cost1[x]+p.second;
                    pr.push({-cost1[p.first],p.first,0});
                }
                if(cost1[x]+(p.second/2)<cost2[p.first]){
                    cost2[p.first]=cost1[x]+(p.second/2);
                    pr.push({-cost2[p.first],p.first,1});
                }
            }
        }
    }
    cout<<min(cost1[n],cost2[n]);
    return 0;
}