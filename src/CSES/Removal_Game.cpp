#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll dp[5001][5001]={0};
ll arr[5001];
ll n;
void cal(ll i,ll j){
    ll turn=(n-(j-i))&1;
    if(dp[i][j]!=0)return;
    if(i==j){
        dp[i][j]=arr[i-1]*turn;
    }else{
        cal(i+1,j);cal(i,j-1);
        dp[i][j]=max(dp[i+1][j]+arr[i-1]*turn,dp[i][j-1]+arr[j-1]*turn);
    }
}
int main(){
    cin>>n;

    for (int i = 0; i < n; i++){cin>>arr[i];}
    
    cal(1,n);
    cout<<dp[1][n];
    return 0;
}