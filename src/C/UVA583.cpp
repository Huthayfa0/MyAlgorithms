#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<ll> VL;
typedef vector<VL> ML;


#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; i < ll(f); i++)
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000000
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix

vector<ll> primeFactors(ll n) {
    vector<ll> f;
    ll x = 2;
    while (x * x <= n) {
        while (n % x == 0) {
            f.push_back(x);
            n /= x;
        }
        x++;
    }
    if (n > 1) f.push_back(n);
    return f;
}
ll n;
void solve(){
    cout<<n<<" = ";
    if(n<0){
        cout<<-1<<" x ";
        n/=-1;
    }
    VL z= primeFactors(n);
    lp(i,0, sz(z)-1){
        cout<<z[i]<<" x ";
    }
    cout<<z[sz(z)-1]<<endl;
}

int main(){
    FAST
    ll t;
    t=1;
    while(cin>>n){
        if(n==0)break;
        solve();
    }

    return 0;
}
