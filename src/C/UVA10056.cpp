#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> VL;
typedef vector<VL> ML;
#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; (i) < ll(f); (i)++)
#define re(i,a) lp(i,0,sz(a)) cin >> (a)[i]
#define out(i,a) lp(i,0,sz(a)) cout << (a)[i] << ((i) == sz(a) - 1 ? '\n' : ' ')
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000007
#define N 100000

#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(4)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations

ld numPow(ld a,ll n){
    if(n==0)return 1;if(n==1)return a;
    ld x= numPow(a,n/2);
    if(n%2==0)return x*x;
    else return x*x*a;
}

void solve(){
    ll n,x;
    ld p;
    cin>>n>>p>>x;
    if(p==0){
        decimalpoint<<0.0<<endl;
        return;
    }
    ld s=p* numPow(1-p,x-1);
    ld ans=s/(1- numPow(1-p,n));
    decimalpoint<<ans<<endl;

}


int main(){

    FAST
    ll t;
    cin>>t;
    while(t--){
       solve();
    }
    return 0;
}
