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
VL generatePrimes(ll n){
    VL t;
    ll arr[n+1];
    arr[0]=arr[1]=1;
    lp(i,2,n+1){
        if(arr[i])continue;
        for (ll j=i+i; j < n + 1; j+=i) {
            arr[j]=1;
        }
        t.pb(i);
    }
    return t;
}
void solve()
{
    VL x= generatePrimes(1000005);
    ll n,m;cin>>n>>m;
    ML arr(n);
    ll t;
    lp(i,0,n){
        arr[i]=VL(m);
        lp(j,0,m){
            cin>>t;
            ll y= lower_bound(all(x),t)-x.begin();
            if(t==2)arr[i][j]=0;
            else arr[i][j]= min(abs(x[y]-t),abs(x[y+1]-t));
        }
    }
    ll mn=1e18+5;
    lp(i,0,n){
        ll sum=0;
        lp(j,0,m){
            sum+=arr[i][j];
        }
        mn=min(mn,sum);
    }
    lp(i,0,m){
        ll sum=0;
        lp(j,0,n){
            sum+=arr[j][i];
        }
        mn=min(mn,sum);
    }
    cout<<mn<<endl;
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
