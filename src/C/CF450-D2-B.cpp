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
#define MOD 1000000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix

ML matMul(ML x,ML y,ll mod){
    if(sz(y)!= sz(x[0])) {cout<<"WRONG\n"; return x; }
    ll b=sz(y);ll n= sz(x);ll m=sz(y[0]);ML ans(n);
    lp(i,0, n){
        ans[i]=VL(m);
        lp(j,0,m){
            ans[i][j]=0;lp(c,0,b)ans[i][j]+=(x[i][c]*y[c][j])%mod;ans[i][j]%=mod;
        }
    }
    return ans;
}
ML matId(ll n){
    ML ans(n);
    lp(i,0,n){
        ans[i]=VL(n);ans[i][i]=1;
    }
    return ans;
}
ML matPow(ML x,ll n,ll mod){
    if(sz(x)!= sz(x[0])) {cout<<"WRONG\n"; return x; }
    if(n==0)return matId(sz(x));if(n==1)return x;
    ML a= matPow(x,n/2,mod);
    if(n%2==0)return matMul(a,a,mod);
    else return matMul(matMul(a,a,mod),x,mod);
}


void solve()
{
    ll f1,f2,n;cin>>f1>>f2>>n;
    ML arr={{1,-1},{1,0}};//(2);arr[0]=VL({1,-1});arr[1]=VL({1,0});
    arr= matPow(arr,n-1,MOD);
    ML in={{(f2+MOD)%MOD},{(f1+MOD)%MOD}};
    in= matMul(arr,in,MOD);
    cout<<(in[1][0]+MOD)%MOD<<endl;
}


int main(){
    FAST
    ll t;
    t=1;
    while (t-->0){
        solve();
    }

    return 0;
}
