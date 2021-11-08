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
bool cmp(string x,string y,ll i){
    if(i==0){
        return x<=y;
    }
    int xx=x.length()-1,yy=y.length()-1;
    if(i==3){
    lp(j,0, min(xx,yy)) {
        if(x[xx-j]<y[yy-j])return true;
        if(x[xx-j]>y[yy-j])return false;
    }
    }
    if(i==2){
        lp(j,0, min(xx,yy)) {
            if(x[xx-j]<y[j])return true;
            if(x[xx-j]>y[j])return false;
        }
    }
    if(i==1){
        lp(j,0, min(xx,yy)) {
            if(x[j]<y[yy-j])return true;
            if(x[j]>y[yy-j])return false;
        }
    }
    return xx<=yy;
}
ML dp;
ll n;
VL arr;
vector<string> str;
ll cal(ll i,ll pre){
    if(i==n)return 0;
    ll&x=dp[i][pre];
    if(x!=-1)return x;
    if(pre==1){
        bool xx= cmp(str[i-1],str[i],3);
        bool yy= cmp(str[i-1],str[i],2);
        if(xx&&yy){
            return x=min(cal(i+1,0),arr[i]+cal(i+1,1));
        }else if(xx){
            return x=arr[i]+cal(i+1,1);
        }else if(yy)return x=cal(i+1,0);
        else return x=1e18+5;
    }else{
        bool xx= cmp(str[i-1],str[i],1);
        bool yy= cmp(str[i-1],str[i],0);
        if(xx&&yy){
            return x=min(cal(i+1,0),arr[i]+cal(i+1,1));
        }else if(xx){
            return x=arr[i]+cal(i+1,1);
        }else if(yy)return x=cal(i+1,0);
        else return x=1e18+5;
    }
}
void solve(){
    cin>>n;
    dp=ML(n,VL(2,-1));
    arr=VL(n),str=vector<string>(n);
    lp(i,0,n)cin>>arr[i];
    lp(i,0,n)cin>>str[i];
    ll ans= min(cal(1,0),arr[0]+ cal(1,1));
    if(ans==1e18+5)
        cout<<-1<<endl;
    else
    cout<<ans<<endl;
}

int main(){
    FAST
    ll t;
    t=1;
    while(t--){
        solve();
    }

    return 0;
}
