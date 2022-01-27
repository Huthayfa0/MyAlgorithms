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
#define decimalpoint cout << std::fixed << setprecision(5)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations

vector<ll> primeFactors(ll n) {
    vector<ll> f;
    if(n<0)
        f.pb(-1),n*=-1;
    while ((n&1)==0){
        n>>=1;
        f.pb(2);
    }
    ll x=3;
    while (x * x <= n) {
        while (n % x == 0) {
            f.pb(x);
            n /= x;
        }
        x+=2;
    }
    if (n > 1) f.pb(n);
    return f;
}
ll numPow(ll a,ll n,ll mod){
    if(n==0)return 1;if(n==1)return a;
    ll x= numPow(a,n/2,mod);
    if(n%2==0)return (x*x)%mod;
    else return (((x*x)%mod)*a)%mod;
}

void solve(){
    ll inf=1e18+5;
    string line;
    while(true) {
        getline(cin,line);
        ll x=1;
        ll v,p;
        stringstream st(line);
        while (st>>v>>p){
            x*= numPow(v,p,inf);
        }
        if(v==0)break;
        map<ll ,ll > mp;
        VL arr= primeFactors(x-1);
        for (auto n:arr) {
            mp[n]++;
        }
        auto it=mp.end();
        it--;
        while (it!=mp.begin()){
            cout<<it->first<<" "<<it->second<<" ";
            it--;
        }
        cout<<it->first<<" "<<it->second<<endl;
    }
}


int main(){

    FAST
    ll t;
    t=1;
    while(t--){
       solve();
    }
    return 0;
}
