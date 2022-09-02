#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    if(n<4){
        if(n==1)cout<<1;
        else
        cout<<"NO SOLUTION";
        return 0;
    }
    ll x=1,y=n/2+1;
    for(ll i=0;i<n/2;i++){
        cout<<y++<<" "<<x++<<" ";
    }
    if(n&1)cout<<y;
    
    return 0;
}