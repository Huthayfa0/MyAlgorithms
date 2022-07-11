#include<bits/stdc++.h>
#include <iostream>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> VL;
typedef vector<VL> ML;
const double PI = acos(-1.0);
const ld EPS = 1e-18;

#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; (i) < ll(f); (i)++)
#define re(i,a) lp(i,0,sz(a)) cin >> (a)[i]
#define out(i,a) lp(i,0,sz(a)) cout << (a)[i] << ((i) == sz(a) - 1 ? '\n' : ' ')
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000007
#define inf 0x3f3f3f3f3f3f3f3fLL
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(2)
typedef complex<ld> point;

using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry
//LinesGeometry CirclesGeometry
pair<ll,ll> sol(const string& x,const string& y){
    ll a=0,b=0;
    lp(i,0,4){
        lp(j,0,4){
            if(x[i]==y[j])
                a++,b+=i==j;
        }
    }
    return {a-b,b};
}
void solve(){
    ll n; cin>>n;
    ML adj(n);
    lp(i,0,n-1){
        ll x,y;cin>>x>>y;
        adj[x-1].pb(y-1);
        adj[y-1].pb(x-1);
    }
    VL init(n),goal(n);
    re(i,init);
    re(i,goal);
    VL ans;
    VL flip(n);
    VL parent(n);
    vector<bool> vis(n);
    ll v=0;
    parent[v] = -1;
    stack<ll> stk;
    stk.push(v);
    while(!stk.empty()){
        v=stk.top();stk.pop();
        if((init[v]!=goal[v])^flip[v]){
            flip[v]^=1;
            ans.pb(v+1);
        }
        vis[v] = true;
        for (ll &e:adj[v]) {
            if (!vis[e]) {
                parent[e] = v;
                flip[e]=parent[v]==-1?0:flip[parent[v]];
                stk.push(e);
            }
        }
    }
    sort(all(ans));
    cout<<ans.size()<<endl;
    lp(i,0,ans.size())cout<<ans[i]<<endl;
}

int main(){
    FAST
    ll t=1;
    //cin>>t;
    //ll nn=t;
    while(t--){
      //cout<<"Case #"<<nn-t<<": ";//<<endl;
      solve();
    }

    return 0;
}
