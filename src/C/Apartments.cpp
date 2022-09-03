#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,k,m,ans=0;cin>>n>>m>>k;ll a[n],b[m];
    for(int i=0;i<n;i++)cin>>a[i];
    for(int i=0;i<m;i++)cin>>b[i];
    sort(b,b+m);
    sort(a,a+n);
    ll i=0,j=0;
    while(i<n&&j<m){
        if(abs(a[i]-b[j])<=k){
            ans++;
            i++;j++;
        }else{
            if(a[i]>b[j])j++;
            else i++;
        }
    }
    cout<<ans;
    return 0;
}