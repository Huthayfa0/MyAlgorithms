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
#define yesno(x) ((x)?"Yes":"No")
typedef complex<ld> point;
 
using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry
//LinesGeometry CirclesGeometry BigInteger
//()&

void solve(){
    ll n,m,s,t;cin>>n>>m>>s>>t;
    vector<vector<pair<ll,ll>>> arr(n);
    lp(i,0,m){
        ll x,y,w;cin>>x>>y>>w;
        arr[x].pb(mp(y,w));
        arr[y].pb(mp(x,w));
    }
    vector<ll> cost(n,inf);
    cost[s]=0;
    set<pair<ll,ll>> que;
    que.insert(mp(0,s));
    while(!que.empty()){
        auto x=*que.begin();
       // cout<<x.F<<" "<<x.S<<endl;
        que.erase(que.begin());
        if(x.S==t)break;
        for(auto p:arr[x.S]){
            if(x.F+p.S<cost[p.F]){
                cost[p.F]=x.F+p.S;
                que.insert(mp(cost[p.F],p.F));
            }
        }
    }
    if(cost[t]!=inf)
    cout<<cost[t]<<endl;
else
cout<<"unreachable"<<endl;
}
 
int main(){
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    FAST
    ll t=1;
    cin>>t;
    ll nn=t;
 
    while(t--){
      cout<<"Case #"<<nn-t<<": ";//<<endl;
      solve();
    }
 
    return 0;
}
