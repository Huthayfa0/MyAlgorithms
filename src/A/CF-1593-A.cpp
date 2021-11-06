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

void solve(){
    ll a[3];
    cin>>a[0]>>a[1]>>a[2];
    ll m= max(a[0], max(a[1],a[2]));
    if(m==a[0]){
        if(m>a[1]&&m>a[2])
            cout<<0;
        else
            cout<<1;
    }else{
        cout<<m-a[0]+1;
    }
    cout<<" ";
    if(m==a[1]){
        if(m>a[0]&&m>a[2])
            cout<<0;
        else
            cout<<1;
    }else{
        cout<<m-a[1]+1;
    }
    cout<<" ";
    if(m==a[2]){
        if(m>a[0]&&m>a[1])
            cout<<0;
        else
            cout<<1;
    }else{
        cout<<m-a[2]+1;
    }
    cout<<endl;

}

int main(){
    FAST
    ll t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
