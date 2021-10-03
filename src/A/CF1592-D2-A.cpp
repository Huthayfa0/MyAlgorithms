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
    ll t;
    cin>>t;
    ll n,h;
    while (t-->0){
        cin>>n>>h;
        vector<ll> arr(n);
        lp(i,0,n) cin>>arr[i];
        multiset<ll> s(all(arr));
        auto e=s.end();
        e--;
        ll m0=*e;
        e--;
        ll m1=*e;
        ll ans=2*(h/(m0+m1));
        if((h%(m0+m1))!=0LL)
            ans++;
        if((h%(m0+m1))>m0)
            ans++;
        cout<<ans<<endl;

    }


    return 0;
}


