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
#define decimalpoint cout << std::fixed << setprecision(6)
typedef complex<ll> point;

using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry


#define X real()
#define Y imag()
#define angle(a)                (atan2((a).imag(), (a).real()))
#define vec(a,b)                ((b)-(a))
#define same(p1,p2)             (dp(vec(p1,p2),vec(p1,p2)) < EPS)
#define dp(a,b)                 ( (conj(a)*(b)).real() )	// a*b cos(T), if zero -> prep
#define cp(a,b)                 ( (conj(a)*(b)).imag() )	// a*b sin(T), if zero -> parllel
#define length(a)               (hypot((a).imag(), (a).real()))
#define normalize(a)            ((a)/length(a))
//#define polar(r,ang)            ((r)*exp(point(0,ang)))  ==> Already added in c++11
#define rotateO(p,ang)          ((p)*exp(point(0,ang)))
#define rotateA(p,ang,about)  (rotateO(vec(about,p),ang)+(about))
#define reflectO(v,m)  (conj((v)/(m))*(m))
point reflect(point p, point p0, point p1) {
    point z = p - p0, w = p1 - p0;
    return conj(z / w) * w + p0;  // Refelect point p1 around p0p1
}

bool intersectSegments(point a, point b, point c, point d, point & intersect) {
    ll d1 = cp(a - b, d - c), d2 = cp(a - c, d - c), d3 = cp(a - b, a - c);
    if (fabs(d1) < EPS)
        return false;  // Parllel || identical

    ll t1 = d2 / d1, t2 = d3 / d1;
    intersect = a + (b - a) * (t1);

    if (t1 < -EPS || t2 < -EPS || t2 > 1 + EPS)
        return false;  //e.g ab is ray, cd is segment ... change to whatever
    return true;
}

// Where is P2 relative to segment p0-p1?
// ccw = +1 => angle > 0 or collinear after p1
// cw = -1 => angle < 0 or collinear after p0
// Undefined = 0 => Collinar in range [a, b]. Be careful here
int ccw(point a, point b, point c) {
    point v1(b - a), v2(c - a);
    ld t = cp(v1, v2);

    if (t > +EPS)
        return +1;
    if (t < -EPS)
        return -1;
    if (v1.X * v2.X < -EPS || v1.Y * v2.Y < -EPS)
        return -1;
    if (norm(v1) < norm(v2) - EPS)
        return +1;
    return 0;
}

bool intersect(point p1, point p2, point p3, point p4) {
    // special case handling if a segment is just a point
    bool x = (p1 == p2), y = (p3==p4);
    if(x && y)  return p1 == p3;
    if(x)   return ccw(p3, p4, p1) == 0;
    if(y)   return ccw(p1, p2, p3) == 0;

    return  ccw(p1, p2, p3) * ccw(p1, p2, p4) <= 0  &&
            ccw(p3, p4, p1) * ccw(p3, p4, p2) <= 0;
}

pair<point,point> res(pair<point,point> a,pair<point,point> b){
    point ans1=point(max(a.F.X,b.F.X),max(a.F.Y,b.F.Y));
    point ans2=point(min(a.S.X,b.S.X),min(a.S.Y,b.S.Y));
    return {ans1,ans2};
}
void solve(){
    ll n;
while(true){
    cin>>n;
    if(n==0)break;
    ML arr(n,VL(4));
    lp(i,0,n)
        re(j,arr[i]);
    pair<point,point> x={point(arr[0][0],arr[0][1]),point(arr[0][0]+arr[0][3],arr[0][1]+arr[0][3])};
    pair<point,point> y={point(arr[0][2],arr[0][1]),point(arr[0][2]+arr[0][3],arr[0][1]+arr[0][3])};
    pair<point,point> z={point(arr[0][0],arr[0][2]),point(arr[0][0]+arr[0][3],arr[0][2]+arr[0][3])};
    lp(i,1,n){
        x= res(x,{point(arr[i][0],arr[i][1]),point(arr[i][0]+arr[i][3],arr[i][1]+arr[i][3])});
        y= res(y,{point(arr[i][2],arr[i][1]),point(arr[i][2]+arr[i][3],arr[i][1]+arr[i][3])});
        z= res(z,{point(arr[i][0],arr[i][2]),point(arr[i][0]+arr[i][3],arr[i][2]+arr[i][3])});
    }
    ll ans=1;
    ans*=max(x.S.X-x.F.X,0LL)*max(x.S.Y-x.F.Y,0LL);
    ans*=max(y.S.X-y.F.X,0LL)*max(y.S.Y-y.F.Y,0LL);
    ans*=max(z.S.X-z.F.X,0LL)*max(z.S.Y-z.F.Y,0LL);
    ans= sqrt(ans);
    cout<<ans<<endl;
}
}

int main(){
    FAST
    ll t=1;
   // cin>>t;
   // ll nn=t;
    while(t--){
       // cout<<"Case #"<<nn-t<<": ";//<<endl;
       solve();
    }
    return 0;
}
