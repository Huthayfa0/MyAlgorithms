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
    ll r1,r2,c1,c2,d1,d2;
    cin>>r1>>r2>>c1>>c2>>d1>>d2;
    ll x,y,z,w;
    for (x = 1; x < 10; ++x) for (y = 1; y < 10; ++y) for (z = 1; z < 10; ++z) for (w = 1; w < 10; ++w){
        if(x+y==r1&&w+z==r2&&x+z==c1&&w+y==c2&&x+w==d1&&z+y==d2&&x!=y&&x!=z&&x!=w&&y!=z&&y!=w&&w!=z){
            goto ans;
        }
    }
    cout<<-1<<endl;
    return 0;
    ans:
    cout<<x<<' '<<y<<endl<<z<<' '<<w<<endl;
    return 0;
}


