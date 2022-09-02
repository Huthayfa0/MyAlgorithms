#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    string x;cin>>x;
    map<char,ll> m;for(auto c:x)m[c]++;
    ll odd=0;
    for(auto &p:m)if(p.second%2){x[x.length()/2]=p.first;odd++;}
    if(odd>(x.length()%2)){
        cout<<"NO SOLUTION";
    }else{
        ll i=0;
        for(auto &p:m){
            for(ll k=0;k<p.second/2;k++){
                x[x.length()-i-1]=p.first;
                x[i++]=p.first;
            }
        }
        cout<<x;
    }
    return 0;
}