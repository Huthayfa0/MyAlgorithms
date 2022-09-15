#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
void mul(vector<vector<ll>>& a,vector<vector<ll>>&b){
    a={
        {
            ((a[0][0]*b[0][0])%MOD+(a[1][0]*b[0][1])%MOD)%MOD,
            ((a[0][1]*b[0][0])%MOD+(a[1][1]*b[0][1])%MOD)%MOD
        },
        {
            ((a[0][0]*b[1][0])%MOD+(a[1][0]*b[1][1])%MOD)%MOD,
            ((a[0][1]*b[1][0])%MOD+(a[1][1]*b[1][1])%MOD)%MOD
        }
    };
}
int main(){
    ll MX=1e6+5;
    ll t,n;cin>>t;
    vector<vector<ll>> s={{2,1},{1,4}}, ans;
    while(t--){
        cin>>n;n--;
        s={{2,1},
           {1,4}};
        ans={{1,0},
             {0,1}};
        while(n>0){
            if(n&1)mul(ans,s);
            n>>=1;
            mul(s,s);
        }
        cout<<(ans[0][0]+ans[0][1]+ans[1][0]+ans[1][1])%MOD<<"\n";
    }
    return 0;
}