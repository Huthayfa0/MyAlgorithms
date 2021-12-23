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
#define MOD 100000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
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
ll gcd(ll a,ll b){
    return b? gcd(b,a%b):a;
}


void solve(){
    ll n;
    while (true){
        cin>>n;
        if(n==0)break;
        bool a=n<0;
        if(a)n*=-1;
        VL x= primeFactors(n);
        unordered_map<ll,ll> m;
        for (auto i:x) {
            m[i]++;
        }
        ll ans=0;
        for (auto i:m) {
            ans= gcd(ans,i.second);
        }
        if(a){
            ans/=ans&~(ans-1);
        }
        cout<<ans<<endl;
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
