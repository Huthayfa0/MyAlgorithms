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

void solve(){
    ll n,k,x,y;cin>>n>>k>>x>>y;
    bool found=false;
    if(n%3==0){
        ll fe=n/3;
        ll q1,q2,q3,count=0;
        q1=k+y+2*x;
        if(q1%3!=0)goto n1;
        q1/=3;
        q2=q1-x;
        q3=q2-y;
        count=0;count+=fe-q1;count+=fe-q3;count+=fe-q2;
        if(q1<0||q2<0||q3<0||fe<q1||fe<q3||fe<q2||(count!=n-k))goto n1;
        found=true;
        n1:
        y*=-1;
        q1=k+y+2*x;
        if(q1%3!=0)goto n2;
        q1/=3;
        q2=q1-x;
        q3=q2-y;
        count=0;count+=fe-q1;count+=fe-q3;count+=fe-q2;
        if(q1<0||q2<0||q3<0||fe<q1||fe<q3||fe<q2||(count!=n-k))goto n2;
        found=true;
        n2:
        y*=-1;
        x*=-1;
        q1=k+y+2*x;
        if(q1%3!=0)goto n3;
        q1/=3;
        q2=q1-x;
        q3=q2-y;
        count=0;count+=fe-q1;count+=fe-q3;count+=fe-q2;
        if(q1<0||q2<0||q3<0||fe<q1||fe<q3||fe<q2||(count!=n-k))goto n3;
        found=true;
        n3:
        y*=-1;
        q1=k+y+2*x;
        if(q1%3!=0)goto n4;
        q1/=3;
        q2=q1-x;
        q3=q2-y;
        count=0;count+=fe-q1;count+=fe-q3;count+=fe-q2;
        if(q1<0||q2<0||q3<0||fe<q1||fe<q3||fe<q2||(count!=n-k))goto n4;
        found=true;

    }
    n4:
    cout<<(found?"yes":"no")<<endl;
}

int main(){
    FAST
    ll t=1;
    cin>>t;
    while(t--){
       solve();
    }
    return 0;
}
