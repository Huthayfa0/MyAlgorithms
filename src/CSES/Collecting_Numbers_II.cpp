#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,m;cin>>n>>m;ll arr[n],dp[n];for(int i=0;i<n;i++){cin>>arr[i];dp[arr[i]-1]=i;}
    ll ans=1;
    for(int i=1;i<n;i++){
        ans+=dp[i]<dp[i-1];
    }
    while(m--){
        ll x,y;cin>>x>>y;
        if(arr[x-1]==arr[y-1])continue;
        if(arr[x-1]>arr[y-1])swap(x,y);
        if(arr[x-1])
        swap(arr[x-1],arr[y-1]);
        x=arr[x-1]-1;
        y=arr[y-1]-1;
        //cout<<x+1<<" "<<y+1<<endl;
        ans-=(x!=0?dp[x]<dp[x-1]:0)+(x!=n-1?dp[x+1]<dp[x]:0);
        ans-=(y!=0&&y-1!=x?dp[y]<dp[y-1]:0)+(y!=n-1&&y!=x-1?dp[y+1]<dp[y]:0);
        swap(dp[x],dp[y]);
        ans+=(x!=0?dp[x]<dp[x-1]:0)+(x!=n-1?dp[x+1]<dp[x]:0);
        ans+=(y!=0&&y-1!=x?dp[y]<dp[y-1]:0)+(y!=n-1&&y!=x-1?dp[y+1]<dp[y]:0);;
        cout<<ans<<"\n";
 
    }
    return 0;
}