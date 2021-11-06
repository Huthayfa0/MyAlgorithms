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
ll n;
vector<pair<ll,ll>> arr;
ML dp;
ML dd;
ll calc(ll i,ll j){
    ll&x=dp[i][j];
    if(x!=-1)return x;
    if(i==j)return x=0;
    if(i+1==j)return x=arr[i].F*arr[i].S*arr[j].S;
    x=1e18;
    lp(ii,i,j){
        ll t=calc(i,ii)+ calc(ii+1,j)+arr[i].F*arr[ii].S*arr[j].S;
        if(t<x){
            x=t;
            dd[i][j]=ii;
        }
    }
    return x;
}
map<ll,pair<ll,ll>> mma;
void track(ll i,ll j){
    ll x=dd[i][j];
    mma[i].F++;
    mma[j].S++;
    if(i+1==j)return;
    if(x==-1)return;
    if(x!=i){
        track(i,x);
    }
    if(j!=x+1){
        track(x+1,j);
    }
}
void solve(){
    mma.clear();
    arr=vector<pair<ll,ll>>(n);
    lp(i,0,n)cin>>arr[i].F>>arr[i].S;
    dp=ML(n,VL(n,-1));
    dd=ML(n,VL(n,-1));
    calc(0,n-1);
    track(0,n-1);
    lp(i,0,n-1){
        lp(j,0,mma[i].F)cout<<'(';
        cout<<"A"<<i+1;
        lp(j,0,mma[i].S)cout<<')';
        cout<<" x ";
    }
    lp(j,0,mma[n-1].F)cout<<'(';
    cout<<"A"<<n;
    lp(j,0,mma[n-1].S)cout<<')';
    cout<<endl;
}

int main(){
    FAST
    ll t=1;
    while(cin>>n){
        if(n==0)break;
        cout<<"Case "<<t++<<": ";
        solve();
    }

    return 0;
}
