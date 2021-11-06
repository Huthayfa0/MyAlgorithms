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


void solve(){
    ll n,q;
    cin>>n>>q;
   vector<pair<ll,ll>>arr(q);
    lp(i,0,q)cin>>arr[i].F>>arr[i].S;
    ll c=0;
    vector<stack<ll>> unread(n);
    vector<pair<ll,bool>> m;
    ll pre=0;
    lp(i,0,q){
        if(arr[i].F==1){
            unread[arr[i].S-1].push(sz(m));
            m.pb(mp(arr[i].S-1,false));
            c++;
        }else if(arr[i].F==2){
            ll xx=arr[i].S-1;
            //c-=sz(unread[xx]);
            while (!unread[xx].empty()){
                if(!m[unread[xx].top()].S) {
                    m[unread[xx].top()].S = true;
                    c--;
                }
                unread[xx].pop();
            }
        }else{
            lp(j,pre,arr[i].S) {
                if(!m[j].S){
                    m[j].S=true;
                    if(!unread[m[j].F].empty()&& unread[m[j].F].top()==j)
                        unread[m[j].F].pop();
                    c--;
                }
            }
            pre= max(arr[i].S,pre);
        }
        cout<<c<<endl;
    }
}

int main(){
    FAST
    ll t=1;
    while(t--){
        solve();
    }

    return 0;
}
