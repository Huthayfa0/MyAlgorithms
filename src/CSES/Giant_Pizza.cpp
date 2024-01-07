#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll MX=200005;
vector<ll> adj[MX],adjinv[MX],proc;
vector<vector<ll>> con;
ll vis[MX],visinv[MX],ans[MX];
 
void dfs(ll x){
    vis[x]=1;
    for(auto v:adj[x]){
        if(!vis[v]){
            dfs(v);
        }
    }
    vis[x]=2;
    proc.push_back(x);
}
void dfs2(ll x,ll i){
    visinv[x]=i;
    for(auto v:adjinv[x]){
        if(!visinv[v]){
            dfs2(v,i);
        }
    }
    con[i].push_back(x);
}
void dfs3(ll x){
    vis[x]=1;
    for(auto v:adj[x]){
        if(!vis[v]){
            dfs3(v);
        }
    }
    proc.push_back(visinv[x]);
}
int main(){
    ll n,m;cin>>n>>m;
    vector<ll> proved;
    for(ll i=0;i<n;i++){
        char x1,x2;
        ll v1,v2;
        cin>>x1>>v1>>x2>>v2;v1*=2;v2*=2;
        if(x1=='-')v1++;
        if(x2=='-')v2++;
        if(v1==v2)proved.push_back(v1);
        adj[v1^1].push_back(v2);
        adj[v2^1].push_back(v1);
        adjinv[v1].push_back(v2^1);
        adjinv[v2].push_back(v1^1);
    }
    for(ll i=2;i<=m*2+1;i++)
        if(!vis[i])
            dfs(i);
    reverse(proc.begin(),proc.end());
    con.push_back(vector<ll>());
    ll conc=0;
    for(auto x:proc){
        if(!visinv[x]){
            con.push_back(vector<ll>());
            dfs2(x,++conc);
        }
    }
    ll acc=1;
    for(auto vec:con){
        for(auto c:vec)vis[c]=vis[c^1]=0;
        for(auto c:vec){
            if(vis[c^1])acc=0;
            vis[c]=1;
        }
    }
    for(auto c:proved)vis[c]=vis[c^1]=0;
    for(auto c:proved){
        if(vis[c^1])acc=0;
        vis[c]=1;
    }
    ll ans[m]={0};
    if(!acc){
        cout<<"IMPOSSIBLE";
    }else{
        proc.clear();
        memset(vis,0,sizeof(vis));
        for(auto i:proved)
            if(!vis[i])
                dfs3(i);
        for(ll i=2;i<=m*2+1;i++)
            if(!vis[i])
                dfs3(i);
        //reverse(proc.begin(),proc.end());
        for(auto x:proc){
            if(ans[con[x][0]/2-1])continue;
            for(auto v:con[x]){
                ans[v/2-1]=(v&1)+1;
            }
        }
        for(auto c:ans){
            if(c==1){
                cout<<"+ ";
            }else{
                cout<<"- ";
            }
        }
    }
 
    return 0;
 
}
