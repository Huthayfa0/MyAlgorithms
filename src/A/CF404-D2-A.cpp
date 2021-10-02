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
    vector<string> arr(n);
    lp(i,0,n) cin>>arr[i];
    char x=arr[0][0];
    char o=arr[0][1];
    bool ans=x!=o;

    lp(i,0,n) lp(j,0,n) {
        if(((i==j||i==(n-j-1))&&x!=arr[i][j])
        ||((!(i==j||i==(n-j-1)))&&o!=arr[i][j])){
            ans=false;
            goto a;
        }
    }
    a:
    cout<<(ans?"YES":"NO")<<endl;
    return 0;
}


