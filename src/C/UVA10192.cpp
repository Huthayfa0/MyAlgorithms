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
char x[200],y[200];
ll n,m;
ML dp;
ll calc(ll i,ll j){
    if(n==i||j==m)return 0;
    if(dp[i][j]!=-1)return dp[i][j];
    if(x[i]==y[j])return dp[i][j]= calc(i+1,j+1)+1;
    return dp[i][j]=max(calc(i+1,j), calc(i,j+1));
}
void solve()
{
    ll t=1;
    while (true){
        fgets(x,200,stdin);
        if(x[0]=='#')break;
        fgets(y,200,stdin);
        n= strlen(x);
        m= strlen(y);
        dp=ML(n,VL(m,-1));
        ll ans=calc(0,0)-1;//-1 is because of the \n at the end
        cout<<"Case #"<<t<<": you can visit at most "<<ans<<" cities."<<endl;
        t++;
    }
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
