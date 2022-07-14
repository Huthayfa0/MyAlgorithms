#include<bits/stdc++.h>
#include <iostream>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> VL;
typedef vector<VL> ML;
const double PI = acos(-1.0);
const ld EPS = 1e-18;

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
#define decimalpoint cout << std::fixed << setprecision(2)
typedef complex<ld> point;

using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry
//LinesGeometry CirclesGeometry BigInteger

void solve(){
   ll n;cin>>n;VL arr(n);re(i,arr);vector<string> strings(n),reversed(n);re(i,strings);
   reversed=strings;
   lp(i,0,n)std::reverse(reversed[i].begin(), reversed[i].end());
   ll ans[100005][2];
   lp(i,0,100005)lp(j,0,2)ans[i][j]=inf;
   ans[0][0]=0;
   ans[0][1]=arr[0];
   lp(i,1,n){
       if(strings[i-1]<=strings[i]){
           ans[i][0]=ans[i-1][0];
       }
       if(reversed[i-1]<=strings[i]){
           chmin(ans[i][0],ans[i-1][1]);
       }
       if(strings[i-1]<=reversed[i]){
           ans[i][1]=ans[i-1][0]+arr[i];
       }
       if(reversed[i-1]<=reversed[i]){
           chmin(ans[i][1],ans[i-1][1]+arr[i]);
       }
   }
   cout<<(min(ans[n-1][0],ans[n-1][1])==inf?-1:min(ans[n-1][0],ans[n-1][1]))<<endl;
}

int main(){
    FAST
    ll t=1;
    //cin>>t;
    //ll nn=t;

    while(t--){
      //cout<<"Case #"<<nn-t<<": ";//<<endl;
      solve();
    }

    return 0;
}
