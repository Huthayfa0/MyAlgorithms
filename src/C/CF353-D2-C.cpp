#include<bits/stdc++.h>
using namespace std;
typedef long long ll;


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

void solve()
{
    ll n;
    cin>>n;
    vector<ll> arr(n);
    lp(i,0,n) cin>>arr[i];
    string x;cin>>x;
    vector<ll> sx(n), sy(n);
    sx[n-1]=(x[n-1]=='1')?arr[n-1]:0;
    for (ll i = n-2; i >= 0LL; --i) {
        sx[i]=sx[i+1]+(x[i]=='1'?arr[i]:0);
    }
    sy[0]=arr[0];
    lp(i,1,n) {
        sy[i]=sy[i-1]+arr[i];
    }
    ll ans=sx[0];
    lp(i,1,n-1){
        if(x[i]=='1') {
            ans = max(ans,sy[i-1]+sx[i+1]);
        }
    }
    if(n!=1&&x[n-1]=='1')ans= max(ans,sy[n-2]);
    cout<<ans<<endl;
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
