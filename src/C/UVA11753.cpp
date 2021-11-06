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
VL arr;
vector<ML> dp;
ll n,k;
ll calc(ll i,ll k1,ll k2){
    if(k1>k||k2>k)return 30;
    ll&x=dp[i][k1][k2];
    ll j=n-1-i-k1+k2;
    if(x!=-1)return x;
    if(i>=j) return x=0;
    if(k1+k2>k)return x=30;
    if(arr[i]==arr[j]) return x=calc(i+1,k1,k2);
    return x=1+min(calc(i+1,k1,k2+1),calc(i,k1+1,k2));
}
struct state{
    ll i,k1,k2;
    bool processed;
    state(ll i,ll k1,ll k2) : i(i),k1(k1),k2(k2),processed(false){};
};
ll calc2(ll i){
    stack<state> stk;
    state cur(0,0,0);
    stk.push(cur);
    ll k1,k2;
    while (!stk.empty()){
        ll j=n-1-i-k1+k2;
        cur=stk.top(),i=cur.i,k1=cur.k1,k2=cur.k2,stk.pop();
        ll&x=dp[i][k1][k2];
      if(x==-1){
          if(i>=j)x=0;
          else if(!cur.processed){
              if (k1 + k2 > k) x = 30;
              cur.processed=true;
              stk.push(cur);
              stk.push(state(i+1,k1,k2));
              stk.push(state(i+1,k1,k2+1));
              stk.push(state(i,k1+1,k2));
          }else{
              if (arr[i] == arr[j])  x = dp[i+1][k1][k2];
              x = 1 + min(dp[i + 1][ k1][ k2 + 1], dp[i][ k1 + 1][ k2]);
          }
      }

    }
    return dp[cur.i][cur.k1][cur.k2];
}
void solve(){
    cin>>n>>k;
    arr=VL(n);
    lp(i,0,n)cin>>arr[i];
    dp=vector<ML>(n,ML(k+5,VL(k+5,-1)));
    ll ans=calc(0,0,0);
    if(ans==0LL){
        cout<<"Too easy"<<endl;
    }else if(ans>k)
        cout<<"Too difficult"<<endl;
    else cout<<ans<<endl;
}

int main(){
    FAST
    ll t;
    cin>>t;
    lp(i,1,t+1){
        cout<<"Case "<<i<<": ";
        solve();
    }

    return 0;
}
