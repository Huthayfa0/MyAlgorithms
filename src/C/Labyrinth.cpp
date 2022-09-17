#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main(){
    ll n,m;cin>>n>>m;
    string arr[n];
    for(ll i=0;i<n;i++)cin>>arr[i];
    char vis[n][m];
    memset(vis,0,sizeof(vis));
    ll ans=0;
    ll si,sj,fi,fj;
    for(ll i=0;i<n;i++){
        for(ll j=0;j<m;j++){
            if(arr[i][j]=='A'){
                si=i;sj=j;
            }
            if(arr[i][j]=='B'){
                fi=i;fj=j;
            }
        }
    }
    queue<pair<pair<ll,ll>,char>> que;
    que.push({{si,sj},'S'});
    while(!que.empty()){
        auto x=que.front();que.pop();
        ll i=x.first.first,j=x.first.second;char c=x.second;
        if(vis[i][j]||arr[i][j]=='#')continue;
        vis[i][j]=c;
        if(i>0){
            que.push({{i-1,j},'U'});
        }
        if(j>0){
            que.push({{i,j-1},'L'});
        }
        if(i<n-1){
            que.push({{i+1,j},'D'});
        }
        if(j<m-1){
            que.push({{i,j+1},'R'});
        }
    }
    if(vis[fi][fj]){
        cout<<"YES"<<"\n";
        stack<char> stk;
        ll i=fi,j=fj;
        while(vis[i][j]!='S'){
            stk.push(vis[i][j]);
            switch(vis[i][j]){
                case 'U':i++;break;
                case 'D':i--;break;
                case 'L':j++;break;
                case 'R':j--;break;
            }
        }
        cout<<stk.size()<<"\n";
        while(!stk.empty()){
            cout<<stk.top();stk.pop();
        }
    }else{
        cout<<"NO"<<"\n";
    }
    return 0;
}