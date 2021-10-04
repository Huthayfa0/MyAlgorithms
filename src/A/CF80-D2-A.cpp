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
    if(!isPrime(m)){
        cout<<"NO"<<endl;
    }else{
        bool x=true;
        lp(i,n+1,m){
            if(isPrime(i)){
                x= false;
                break;
            }
        }
        if(x){
            cout<<"YES"<<endl;
        }else{
            cout<<"NO"<<endl;
        }
    }
    return 0;
}


