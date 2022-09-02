#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll q;cin>>q;
    while(q--){
        ll k;cin>>k;
        ll x=9,i=1;

        ll goal=0;
        while(k>x*i){
            goal+=x;
            k-=x*i;
            x*=10;
            i++;
        }
        goal+=k/i+(k%i!=0);
        //cout<<goal<<endl;
        k%=i;
        k=i-k;k%=i;
        //cout<<k<<endl;
        while(k--)goal/=10;
        cout<<goal%10<<"\n";
    }
    return 0;
}