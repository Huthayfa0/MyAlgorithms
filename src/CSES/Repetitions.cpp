#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    string x;cin>>x;
    ll cur=1,ans=1;
    for(ll i=1;i<x.length();i++){
        if(x[i]!=x[i-1])cur=0;cur++;
        ans=max(ans,cur);
    }
    cout<<ans<<'\n';
    return 0;
}