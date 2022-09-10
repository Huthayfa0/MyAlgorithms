#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    ll n;cin>>n;
    ll arr[n];for(ll i=0;i<n;i++)cin>>arr[i];
    stack<ll> stk;
    for(ll i=0;i<n;i++){
        while(!stk.empty()&&arr[stk.top()]>=arr[i])stk.pop();
        if(stk.empty()){
            cout<<"0 ";
        }else{
            cout<<stk.top()+1<<" ";
        }
        stk.push(i);
    }
    return 0;
}