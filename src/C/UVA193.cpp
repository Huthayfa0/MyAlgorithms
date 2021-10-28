#include<bits/stdc++.h>
using namespace std;
typedef long long ll;


#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; i < ll(f); i++)
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization

ll n,m;
vector<vector<ll>> adj;
vector<ll> tt;
ll tn;
vector<ll> ans;
ll sn;
bool check(ll x){
    if(x==n+1)return true;
    for (ll c:adj[x]) {
        if(tt[c])
            return false;
    }
    return true;
}
void calc(ll x){

    lp(i,x+1,n+1){
        if(check(i)){
            tt[i]=1;
            tn++;
            calc(i);
            tt[i]=0;
            tn--;
        }
    }
    if(tn>sn){
        sn=tn;
        ans=tt;
    }

}
void solve() {
    cin>>n>>m;
    tn=0;sn=0;
    adj=vector<vector<ll>>(n+1);
    ans=vector<ll>(n+1);
    tt=vector<ll>(n+1);
    ll x,y;
    lp(i,0,m){
        cin>>x>>y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    calc(0);
    cout<<sn<<endl;
    if(sn!=0){
        vector<ll> xx;
        lp(i,1,n+1){
            if(ans[i]){
                xx.push_back(i);
            }
        }
        cout<<xx[0];
        lp(i,1, sz(xx)){
            cout<<" "<<xx[i];
        }
        cout<<endl;
    }
}

int main(){
    FAST
    ll t;
    cin>>t;
    while (t-->0){
        solve();
    }

    return 0;
}
