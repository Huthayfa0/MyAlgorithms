#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll cost(char c, char cc);

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
    string x;
    char c='a';
    cin>>x;
    ll ans=0;
    for (auto cc:x) {
        ans+=cost(c,cc);
        c=cc;
    }
    cout<<ans<<endl;
    return 0;
}

ll cost(char c, char cc) {
    return min(abs(c-cc), abs(abs(c-cc)-26));
}

