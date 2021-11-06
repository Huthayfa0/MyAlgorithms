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
ML dp;
vector<vector<bool>> palindorim;
string str;

ll calc(ll i,ll j){
    ll&x=dp[i][j];
    if(x!=-1)return x;
    if(i==j)return x=1;
    if(((i-j)&1)||(str[i]!=str[j]))return x=0;
    x=0;
    lp(ii,i+1,j+1){
        if(str[ii]==str[i]) {
            x += calc(i+1, ii-1)* calc(ii, j)%MOD;
            x%=MOD;
        }
    }
    return x;
}
void solve(){
    ll n=str.length();
    dp=ML(n,VL(n,-1));
    ll ans=calc(0,n-1);
    cout<<ans<<endl;
}

int main(){
    FAST
    ll t;
    t=1;
    while(cin>>str){
        solve();
    }

    return 0;
}
