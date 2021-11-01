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

void solve()
{
    ll n,m;
    cin>>n>>m;
    bitset<101> a,b;
    ML arr(n,VL(m));
    lp(i,0,n){
        lp(j,0,m){
            cin>>arr[i][j];
            if(!arr[i][j]){
                a[i]=true;
                b[j]=true;
            }
        }
    }
    bool x=true;
    lp(i,0,n)
        lp(j,0,m)
            if(arr[i][j]&&(a[i]&&b[j])) {
                x = false;
                goto next;
            }
    next:
    a^=(1<<n)-1;
            b^=(1<<m)-1;
    if(x&&((a==0&&b==0)||(a!=0&&b!=0))){
        a^=(1<<n)-1;
        b^=(1<<m)-1;
        cout<<"YES"<<endl;
        lp(i,0,n){
            cout<<!(a[i]||b[0]);
            lp(j,1,m){
                cout<<" "<<!(a[i]||b[j]);
            }
            cout<<endl;
        }
    }else{
        cout<<"NO"<<endl;
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
