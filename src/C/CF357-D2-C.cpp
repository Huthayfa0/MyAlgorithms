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


bool isPrime(ll num){
    if (num < 2) return false;
    ll x = 2;
    while (x * x <= num) {
        if (num % x == 0) return false;
        x++;
    }
    return true;
}

int main() {
    FAST
    ll n,m;
    cin>>n>>m;
    vector<ll[3]> q(m);
    vector<ll> ans(n);
    lp(i,0,m){
        cin>>q[i][0]>>q[i][1]>>q[i][2];
        q[i][0]--;q[i][2]--;
    }
    vector<ll> next(n);
    lp(i,0,n){
        next[i]=i+1;
    }
    lp(i,0,m){
        auto x=q[i];
        ll j=x[0];
        while(j<x[1]){
            if(ans[j]==0&&(j!=x[2]))
                ans[j]=x[2]+1;
            ll t=next[j];
            next[j]= j<x[2]?max(x[2],next[j]):max(x[1],next[j]);
            j=j<x[2]?min(x[2],t):t;

        }
    }
    cout<<ans[0];
    lp(i,1,n)
    cout<<" "<<ans[i];
    cout<<endl;
    return 0;
}


