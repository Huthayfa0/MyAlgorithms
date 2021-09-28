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

int main() {
    FAST
    ll ans=0;
    ll n;
    cin>>n;
    vector<pair<ll,ll>> v(n);
    lp(i,0,n) cin>>v[i].first>>v[i].second;
    unordered_map<ll,ll> x,s;
    lp(i,0,n){
        x[v[i].first]++; s[v[i].second]++;
    }
    for (auto p:x) {
        ans+=s[p.first]*p.second;
    }
    cout<<ans<<endl;
    return 0;
}


