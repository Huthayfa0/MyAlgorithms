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

void solve()
{
    ll n,a;
    cin>>n>>a;
    VL arr(n);
    ll sum=0;
    lp(i,0,n) { cin >> arr[i];sum+=arr[i]; }
    ll mx=min(a-n+1,arr[0]);
    ll mn=max(a-sum+arr[0],1LL);
    cout<<arr[0]-mx+mn-1;
    lp(i,1,n){
        mx=min(a-n+1,arr[i]);
        mn=max(a-sum+arr[i],1LL);
        cout<<" "<<arr[i]-mx+mn-1;
    }
    cout<<endl;

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
