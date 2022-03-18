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
pair<ll,ll> next(pair<ll,ll> mx,pair<ll,ll> cur,ll i){
    ll x;
    switch(i){
        case 2:
            cur.F=mx.F;
            return cur;
            case 3:
            cur.S=mx.S;
            return cur;
        case 0:
            cur.F=0;
            return cur;
        case 1:
            cur.S=0;
            return cur;
        case 4:
            x=mx.S-cur.S;
            cur.S-=min(cur.F,x);
            cur.F-=min(cur.F,x);
            return cur;
        case 5:
            x=mx.F-cur.F;
            cur.F-=min(cur.S,x);
            cur.S-=min(cur.S,x);
            return cur;
        default: return cur;
    }
}
void solve(){
    ll n,k,q,N=300000;
    VL ar(N),ans(N);
    cin>>n>>k>>q;
    vector<pair<ll,ll>> arr(n);
    vector<pair<ll,ll>> ques(q);
    lp(i,0,n)cin>>arr[i].F>>arr[i].S;
    lp(i,0,q)cin>>ques[i].F>>ques[i].S;
    lp(i,0,n) {
        ar[arr[i].F]++;
        ar[arr[i].S+1]--;
    }
    ans[0]=0;
    ll count=0;
    lp(i,1,N) {
        count+=ar[i];
        ans[i]=ans[i-1]+(count>=k);
    }
    lp(i,0,q){
        cout<<ans[ques[i].S]-ans[ques[i].F-1]<<endl;
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
