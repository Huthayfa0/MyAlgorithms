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
ll n;
VL arr;
ll sum;
ML dp;
ll calc(ll i,ll s){
    if(i==n)return abs(2*s-sum);
    if(dp[i][s]!=-1)return dp[i][s];
    return dp[i][s]= min(calc(i+1,s), calc(i+1,s+arr[i]));
}
void solve()
{
    cin>>n;
    sum=0;
    arr= VL(n);
    lp(i,0,n) { cin >> arr[i];sum+=arr[i];}
    dp=ML(102,VL(50005,-1));
    ll ans= calc(0,0);
    cout<<ans<<endl;

}


int main(){
    FAST
    ll t;
    cin>>t;
    while (t-->0){
        solve();
    }

    return 0;
}
