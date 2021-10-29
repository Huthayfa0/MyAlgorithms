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

void solve(){
    ll n,d;
    cin>>n>>d;
    vector<ll> a(n);
    lp(i,0,n) cin>>a[i];
    ll ans=0;
    lp(i,0,n-1){
        ll x= (lower_bound(a.begin()+i,a.end(),a[i]+d)-a.begin());
        if(x==i)continue;
        x=x-i-((x==n||a[x]!=a[i]+d)?1:0);
        ans+=x*(x-1)/2;
    }
    cout<<ans;

}


int main(){
    FAST
    ll t;
    t=1;
    while (t-->0){
        solve();
    }

    return 0;
}
