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
#define MOD 1000000000
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix
ll st;
ll n;
VL arr;
ML dp;
ll calc(ll i,ll j){
    ll&x=dp[i][j];
    if(x!=-1)return x;
    if(i==j)return x=0;
    if(i+1==j)return x=0;
    x=1e18;
    lp(ii,i+1,j){
       x=min(calc(i,ii)+ calc(ii,j),x);
    }
    return x=x+arr[j]-arr[i];
}
void solve(){
    cin>>n;
    arr=VL(n+2);
    lp(i,1,n+1)cin>>arr[i];
    dp=ML(n+2,VL(n+2,-1));
    arr[n+1]=st;
    cout<<"The minimum cutting is "<<calc(0,n+1)<<"."<<endl;


}

int main(){
    FAST
    ll t;
    while(cin>>st){
        if(st==0)break;
        solve();
    }

    return 0;
}
