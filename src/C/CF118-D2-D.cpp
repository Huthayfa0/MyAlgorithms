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
#define MOD 100000000
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
//LinesGeometry CirclesGeometry

void solve(){
    ll n1,n2,k1,k2;cin>>n1>>n2>>k1>>k2;
    ll ans[110][110][30];
    mm(ans);

    lp(i,1,k1+1){
        ans[i][0][i]=1;
    }
    lp(i,1,k2+1){
        ans[0][i][k1+i]=1;
    }
    lp(i1,1,n1+1)lp(i2,1,n2+1) {

        lp(j, 2, k1 + 1) {
            ans[i1][i2][j]+=ans[i1-1][i2][j-1];
            ans[i1][i2][j]%=MOD;
        }
        lp(j, 2, k2 + 1) {
            ans[i1][i2][k1+j]+=ans[i1][i2-1][k1+j-1];
            ans[i1][i2][k1+j]%=MOD;
        }

        //  ans[i1][i2][1]=sum of ans[i1-1][i2][k1+(1..k2+1)]
        //  ans[i1][i2][k1+1]=sum of ans[i1][i2-1][(1..k1+1)]
        lp(j, 1, k2 + 1) {
            ans[i1][i2][1]+=ans[i1-1][i2][k1+j];
            ans[i1][i2][1]%=MOD;
        }
        lp(j, 1, k1 + 1) {
            ans[i1][i2][k1+1]+=ans[i1][i2-1][j];
            ans[i1][i2][k1+1]%=MOD;
        }


        }

    ll s=0;
    lp(i,1,k1+k2+1){
        s+=ans[n1][n2][i];
        s%=MOD;
    }
    cout<<s<<endl;

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
