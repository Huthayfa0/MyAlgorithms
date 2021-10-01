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
    ll n;
    cin>>n;
    vector<ll> x,y,z;
    ll c;
    lp(i,0,n) {
        cin>>c;
        if(c==1)
            x.push_back(i+1);
        else if(c==2)
            y.push_back(i+1);
        else
            z.push_back(i+1);
    }
    ll ans= min(min(sz(x), sz(y)), sz(z));
    cout<<ans<<endl;
    lp(i,0,ans){
        cout<<x[i]<<" "<<y[i]<<" "<<z[i]<<endl;
    }
    return 0;
}


