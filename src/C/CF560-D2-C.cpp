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
vector<ll> x(6);
ll calc(){
    return (x[0]+x[1]+x[2])*(x[0]+x[1]+x[2])-x[0]*x[0]-x[2]*x[2]-x[4]*x[4];
}
void solve()
{
    lp(i,0,6) cin>>x[i];
    cout<<calc()<<endl;
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
