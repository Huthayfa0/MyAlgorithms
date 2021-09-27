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
    vector<ll> arr(n);
    lp(i,0,n) cin>>arr[i];
    ll ans=0;
    ll x=0;
    lp(i,0,n) {
        if(arr[i]>0)
            x+=arr[i];
        else{
            if(x>0){
                x--;
            }else
                ans++;
        }

    }
    cout<<ans<<endl;
    return 0;
}

