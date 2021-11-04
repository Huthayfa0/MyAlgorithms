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
vector<string> arr;
ML loops;
ML dp;
ll n,m;
vector<vector<bool>> vis;
void markLoops(ll i,ll j){
    vector<vector<bool>> v(n,vector<bool>(m,false));
    ll ci=i,cj=j;

    while (true){
        if(v[ci][cj])break;
        v[ci][cj]=true;
        if(vis[ci][cj])return;
        vis[ci][cj]=true;
        switch (arr[ci][cj]){
            case 'D':
                ci++;
                if(ci>=n){
                    loops[ci-1][cj]=-2;
                    return;
                }
                break;
                case 'U':
                    ci--;
                    if(ci<0){
                        loops[ci+1][cj]=-2;
                        return;
                    }
                    break;
                    case 'R':
                        cj++;
                        if(cj>=m){
                            loops[ci][cj-1]=-2;
                            return;
                        }
                        break;
                        default:
                            cj--;
                            if(cj<0){
                                loops[ci][cj+1]=-2;
                                return;
                            }
        }
    }
    ll c=0;
    i=ci;j=cj;
    while (true){
        c++;
        switch (arr[ci][cj]){
            case 'D':
                ci++;
                break;
                case 'U':
                    ci--;
                    break;
                    case 'R':
                        cj++;
                        break;
                        default:
                            cj--;

        }
        if(ci==i&&cj==j)break;

    }
    while (true){
        loops[ci][cj]=c;
        switch (arr[ci][cj]){
            case 'D':
                ci++;
                break;
                case 'U':
                    ci--;
                    break;
                    case 'R':
                        cj++;
                        break;
                        default:
                            cj--;

        }
        if(ci==i&&cj==j)break;
    }
}
ll count(ll i,ll j){
    ll ci=i,cj=j;
    if(dp[ci][cj]!=-1)return dp[ci][cj];
    if(loops[ci][cj]>0)return dp[ci][cj]=loops[ci][cj];
    else if(loops[ci][cj]==-2)return dp[ci][cj]=1;
    //c++;
    switch (arr[ci][cj]){
        case 'D':
            ci++;
            break;
            case 'U':
                ci--;
                break;
                case 'R':
                    cj++;
                    break;
                    default:
                        cj--;

    }
    return dp[i][j]=1+ count(ci,cj);
}
void solve()
{

    cin>>n>>m;
    arr=vector<string> (n);
    lp(i,0,n){
        cin>>arr[i];
    }
    loops=ML (n,VL(m,-1));
    vis= vector<vector<bool>>(n,vector<bool>(m,false));
    lp(i,0,n){
        lp(j,0,m){
            if(!vis[i][j])
                markLoops(i,j);
        }
    }
    ll mx=0;
    ll ci=-1,cj=-1;
    dp=ML(n,VL(m,-1));
    lp(i,0,n){
        lp(j,0,m){
            if(dp[i][j]==-1) {
                ll c=count(i, j);
                if(c>mx) {
                    mx = c;
                    ci=i;
                    cj=j;
                }
            }
        }
    }
    cout<<ci+1<<" "<<cj+1<<" "<<mx<<endl;
}



int main(){
    FAST
    ll t;
    cin>>t;
    while (t-->0){
        solve();
    }

    return 0;
}
