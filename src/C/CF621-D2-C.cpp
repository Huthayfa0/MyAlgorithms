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
#define N 105
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

ll n,p;
vector<pair<ll,ll>> arr;

void solve(){
    cin>>n>>p;
    arr=vector<pair<ll,ll>>(n);
    lp(i,0,n)cin>>arr[i].F>>arr[i].S;
    ld dd=1;
    lp(i,0,n) dd*=arr[i].S-arr[i].F+1;
    ld ans=0;

    lp(i,0,n){
        ll j=(i+1)%n;
        ld a=arr[i].S-arr[i].F+1-(arr[i].S/p-(arr[i].F-1)/p);
        ld b=arr[j].S-arr[j].F+1-(arr[j].S/(p)-(arr[j].F-1)/(p));
        ans+=1000-a*b*1000/(arr[i].S-arr[i].F+1)/(arr[j].S-arr[j].F+1);
    }
    decimalpoint<<ans*2<<endl;
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
