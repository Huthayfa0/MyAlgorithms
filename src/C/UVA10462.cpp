#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> VL;
typedef vector<VL> ML;

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
#define N 105
#define inf 0x3f3f3f3f3f3f3f3fLL
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(0)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations

ML edges;
VL ranks;
VL parent;
ll getSet(ll i){
    if (parent[i] == i) return i;
    else return parent[i]=getSet(parent[i]);
}
bool unionSets(ll i, ll j){
    ll ii = getSet(i);
    ll jj = getSet(j);
    if (ii != jj) {
        if (ranks[ii] > ranks[jj]) {
            parent[jj] = ii;
        } else if (ranks[jj] > ranks[ii]) {
            parent[ii] = jj;
        } else {
            parent[ii] = jj;
            ranks[jj]++;
        }
        return true;
    }
    return false;
}
ll n,m;VL used;
ll kruskal() {
    sort(all(edges),[](VL& a,VL& b){return a[2] < b[2];});
    ll cost = 0;
    ll count=0;
    lp(i,0, sz(edges))
        if (unionSets(edges[i][0], edges[i][1]))
            cost += edges[i][2],count++,used.pb(i);
    return count==n-1?cost:inf;
}
ll kruskal(ll x) {
    //sort(all(edges),[](VL a,VL b){return a[2] < b[2];});
    ll cost = 0;
    ll count=0;
    lp(i,0, sz(edges))
        if (i!=x&&unionSets(edges[i][0], edges[i][1]))
            cost += edges[i][2],count++;
    return count==n-1?cost:inf;
}

void solve(){
   cin>>n>>m;
   if(n==1){
       if(m>0){
           ll xx=inf;
           lp(i,0,n+1) parent[i]=i,ranks[i]=0;
           lp(i,0,m){
               VL x(3);
               lp(k,0,3)cin>>x[k];
               edges.pb(x);
           }
           for (auto e: edges) {
               chmin(xx, e[2]);
           }
           cout << xx<<endl;
       }
       else
       cout << "No second way"<<endl;
       return;
   }
    edges.clear();
   used.clear();
    lp(i,0,n+1) parent[i]=i,ranks[i]=0;
    lp(i,0,m){
        VL x(3);
        lp(k,0,3)cin>>x[k];
        edges.pb(x);
    }
    ll mx= kruskal();
    if(mx==inf){
        cout<<"No way";
    }else {
        mx = inf;
        for (auto e: used) {
            lp(i,0,n+1) parent[i]=i,ranks[i]=0;
            chmin(mx, kruskal(e));
        }
        if (mx == inf) {
            cout << "No second way";
        }else{
            cout<<mx;
        }
    }

    cout<<endl;
}

int main(){
    parent=VL(N);
    ranks=VL(N);
    FAST
    ll t;
    cin>>t;
    ll tt=t;
    while(t--){
        cout<<"Case #"<<tt-t<<" : ";
       solve();
    }
    return 0;
}
