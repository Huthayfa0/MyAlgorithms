#include<bits/stdc++.h>
#include <iostream>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
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
#define inf 0x3f3f3f3f3f3f3f3fLL
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(6)
using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations
#define N 3000

ll numPow(ll a,ll n,ll mod){
    if(n==0)return 1;if(n==1)return a;
    ll x= numPow(a,n/2,mod);
    if(n%2==0)return (x*x)%mod;
    else return (((x*x)%mod)*a)%mod;
}
ll divInv(ll a,ll m=MOD){
   return numPow(a,m-2,m);
}
ll fact[N],invfact[N];
void init(){
    fact[0]=1;
    ll x=1;
    lp(i,1,N){
        fact[i]=i*fact[i-1]%MOD;
    }
    ll i=N-1;
    invfact[i]= divInv(fact[i],MOD);
    for (i--; i>=0 ; i--) {
        invfact[i]=invfact[i+1]*(i+1)%MOD;
    }
}
ll ncr(ll n, ll r){
    if(n<0||r<0||r>n)return 0;
    return fact[n]*invfact[r]%MOD*invfact[n-r]%MOD;
}

ll n,k;
ML adj;
void solve(){
    cin>>n>>k;
    adj=ML(n);
    lp(i,1,n){
        ll x;
        cin>>x;
        adj[x].pb(i);
    }n--;
    ll ans=(k*numPow(k-1,n,MOD))%MOD;
    lp(i,1,n){
        ll cur=((k-i)*numPow(k-i-1,n,MOD))%MOD;
        cur*=ncr(k,k-i);
        cur%=MOD;

        ans+=(i&1)?MOD-cur:cur;
        ans%=MOD;
    }
    cout<<ans<<endl;
}

int main(){
    init();

    FAST
    ll t=1;
    //cin>>t;
    while(t--){
       solve();
    }
    return 0;
}
