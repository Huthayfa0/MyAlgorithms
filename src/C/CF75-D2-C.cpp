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
#define N 105
#define inf 0x3f3f3f3f3f3f3f3fLL
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(0)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations
ll gcd(ll a,ll b){
    return b? gcd(b,a%b):a;
}

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
set<ll> values;
VL factors;
ll n;
void generate(ll x=1,ll i=0){
    if(i==n)
        values.insert(x);
    else{
        generate(x,i+1);
        generate(x*factors[i],i+1);
    }
}
void solve(){
   ll a,b;
   cin>>a>>b;
   ll x= gcd(a,b);
   factors= primeFactors(x);

   n= sz(factors);
   values.clear();
    generate();
    ll q;cin>>q;
    while (q--){
        ll low,high;cin>>low>>high;
        auto t=values.upper_bound(high);
        t--;
        if(*t>high||*t<low){
            cout<<-1;
        }else{
            cout<<*t;
        }
        cout<<endl;
    }
}

int main(){
    FAST
    ll t=1;
    //cin>>t;
    while(t--){
       solve();
    }
    return 0;
}
