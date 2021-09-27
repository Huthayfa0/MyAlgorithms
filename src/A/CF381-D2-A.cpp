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
//KruskalMST PrimeCheck Factorization

int main() {
    FAST
    ll n;
    cin>>n;
    vector<ll> arr(n);
    lp(i,0,n) cin>>arr[i];
    ll f=0,s=0;
    bool x=true;
    while (n-->0){
        ll t=0;
        if((arr.front())>(arr.back())){
            t=(arr.front());
            arr.erase(arr.begin());
        }else{
            t=(arr.back());
            arr.pop_back();
        }
        if(x){
            f+=t;
        }else s+=t;
        x=!x;
    }
    cout<<f<<" "<<s<<endl;
    return 0;
}

