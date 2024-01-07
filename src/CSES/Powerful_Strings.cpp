#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<vector<ll>> mat;
#define MX 1000005
#define MOD 1000000007
mat mul(mat &a,mat &b){
    mat ans(a.size(),vector<ll>(b[0].size(),0));
    for(ll i=0;i<a.size();i++)
        for(ll j=0;j<b[0].size();j++)
            for(ll k=0;k<b.size();k++){
                ans[i][j]+=a[i][k]*b[k][j]%MOD;
                ans[i][j]%=MOD;
            }
    return ans;
}
mat mat_pow(mat &x,ll y){
    mat ans(x.size(),vector<ll>(x.size(),0));
    for(int i=0;i<x.size();i++)ans[i][i]=1;
    while(y>0){
        if(y&1)ans=mul(ans,x);
        y>>=1;
        x=mul(x,x);
    }
    return ans;
}
int main(){
   ll n;cin>>n;
   mat arr={{0,1,0},
            {0,0,1},
            {2,2,26}};
   mat v={{1},{26}};
   mat ans=mat_pow(arr,4);
   //ans=mul(ans,v);
   for(int i=0;i<ans.size();i++){
     for(int j=0;j<ans[i].size();j++){
        cout<<ans[i][j]<<" ";
     }
     cout<<"\n";
   }
   return 0;
}