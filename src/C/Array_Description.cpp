#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
int main(){
    ll n,x;cin>>n>>x;ll vv[x+2]={0},nn[x+2]={0};
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    if(arr[0]==0){
        fill_n(vv,x+2,1);
        vv[0]=0;
        vv[x+1]=0;
    }else{
        vv[arr[0]]=1;
    }
    ll *val=vv,*next=nn;
    for(ll i=1;i<n;i++){
        if(arr[i]){
            for(ll j=1;j<=x;j++){
                next[j]=0;
            }
            next[arr[i]]=(val[arr[i]]+val[arr[i]-1]+val[arr[i]+1])%MOD;
        }else{
            for(ll j=1;j<=x;j++){
                next[j]=(val[j]+val[j-1]+val[j+1])%MOD;
            }
        }
        swap(val,next);
    }
    ll s=0;
    for(ll j=1;j<=x;j++){
        s=(val[j]+s)%MOD;
    }
    cout<<s;
    return 0;
}