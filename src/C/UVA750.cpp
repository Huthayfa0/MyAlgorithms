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
vector<ll> y(8);
vector<ll> r(15);
vector<ll> rr(15);
vector<ll> ans(8);
vector<vector<ll>> f;
ll c;
ll yy;
bool valid(ll i,ll j){
    return !(y[i]||r[j-i+7]||rr[14-j-i]);
}
void calc(ll j){
    if(j==8){
        f.push_back(ans);
    }
    if(j==yy) { calc(j + 1);return; }
    lp(i,0,8){
        if(valid(i,j)){
            ans[j]=i+1;y[i]=1;r[j-i+7]=1;rr[14-j-i]=1;
            calc(j+1);
            y[i]=0;r[j-i+7]=0;rr[14-j-i]=0;
        }
    }
}
void solve() {
    f.clear();
    lp(i,0,8){
        ans[i]=0;
        y[i]=0;

    }
    lp(i,0,15){
        r[i]=0;
        rr[i]=0;
    }
    ll xx;cin>>xx>>yy;xx--;yy--;y[xx]=1;r[yy-xx+7]=1;rr[-yy-xx+14]=1;ans[yy]=xx+1;
    calc(0);
    cout<<
          "SOLN       COLUMN\n"
          " #      1 2 3 4 5 6 7 8\n";
    lp(i,0, sz(f)){
        cout<<endl;
        if(i<9)
            cout<<" ";
        cout<<i+1<<"      ";
        cout<<f[i][0];
        lp(ii,1,8){
            cout<<" "<<f[i][ii];
        }

    }
}

int main(){
    FAST
    ll t;
    cin>>t;
    while (t-->0){
        solve();
        if(t!=0)
            cout<<endl<<endl;
        else
            cout<<endl;
    }

    return 0;
}
