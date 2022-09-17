#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
void dfs(ll i,ll j,bool vis[][1000],string* arr, ll n, ll m){
    if(!vis[i][j]&&arr[i][j]=='.'){
        vis[i][j]=true;
        if(i>0){
            dfs(i-1,j,vis,arr,n,m);
        }
        if(j>0){
            dfs(i,j-1,vis,arr,n,m);
        }
        if(i<n-1){
            dfs(i+1,j,vis,arr,n,m);
        }
        if(j<m-1){
            dfs(i,j+1,vis,arr,n,m);
        }
    }
}
int main(){
    ll n,m;cin>>n>>m;
    string arr[n];
    for(ll i=0;i<n;i++)cin>>arr[i];
    bool vis[n][1000];
    memset(vis,0,sizeof(vis));
    ll ans=0;
    for(ll i=0;i<n;i++){
        for(ll j=0;j<m;j++){
            if(!vis[i][j]&&arr[i][j]=='.'){
                ans++;
                dfs(i,j,vis,arr,n,m);
            }
        }
    }
    cout<<ans;
    return 0;
}