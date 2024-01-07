#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MX 1000005
#define MOD 1000000007
vector<vector<ll>> mul(vector<vector<ll>> a,vector<vector<ll>> b){
    vector<vector<ll>> ans(a.size(),vector<ll>(b[0].size(),0));
    for(ll i=0;i<a.size();i++){
        for(ll j=0;j<b[0].size();j++){
            for(ll k=0;k<a[0].size();k++){
                ans[i][j]+=a[i][k]*b[k][j]%MOD;
                ans[i][j]%=MOD;
            }
        }
    }
    return ans;
}
int main(){
   ll n;cin>>n;
   vector<vector<ll>> arr(6,vector<ll>(6,0)),ans(6,vector<ll>(6,0));
   for(ll i=0;i<6;i++){
    ans[i][i]=1;
   }
   for(ll i=0;i<5;i++){
    arr[i][i+1]=1;
    arr[5][i]=1;
   }
   arr[5][5]=1;
   while(n>0){
    if(n&1)
        ans=mul(ans,arr);
    arr=mul(arr,arr);
    n/=2;
   }
   for(auto x: ans){
    for(auto y:x) cout<<y<<" ";
    cout<<"\n";
   }
   cout<<ans[5][5];
   return 0;
}