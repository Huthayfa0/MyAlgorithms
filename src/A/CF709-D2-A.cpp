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
    ll n,b,d;
    cin>>n>>b>>d;
    vector<ll> arr(n);
    lp(i,0,n) cin>>arr[i];
    ll sum=0;
    ll count=0;
    lp(i,0,n){
        if(arr[i]>b)
            continue;
        sum+=arr[i];
        if(sum>d) {
            sum = 0;
            count++;
        }
    }
    cout<<count<<endl;
    return 0;
}


