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
ll cc=0;
ll x[]={1,-1,0,0};
ll y[]={0,0,-1,1};
vector<string> arr;
ll n,m,k;
void dfs(ll i,ll j) {
    stack<pair<ll,ll>> stk;
    stk.push(mp(i,j));
    while (cc>0){
        i=stk.top().F,j=stk.top().S,stk.pop();
        if(i<0||i>=n||j<0||j>=m||arr[i][j]!='X')continue;
        arr[i][j]='.';
        cc--;
        lp(aa,0,4){
            stk.push(mp(i+x[aa],j+y[aa]));
        }
    }
}

void solve(){

    cin>>n>>m>>k;
   arr= vector<string>(n);
    lp(i,0,n)cin>>arr[i];
    ll c=0;
    ll ii,jj;
    lp(i,0,n){
        lp(j,0,m){
            if(arr[i][j]=='.'){
                c++;
                arr[i][j]='X';
                ii=i,jj=j;
            }
        }
    }
    cc=c-k;
    dfs(ii,jj);
    lp(i,0,n)
    cout<<arr[i]<<endl;
}

int main(){
    FAST
    ll t=1;
    while(t--){
        solve();
    }

    return 0;
}
