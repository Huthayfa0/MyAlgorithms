#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,xx;cin>>xx>>n;ll arr[n];for(int i=0;i<n;i++){cin>>arr[i];}
    multiset<ll> ms;set<ll> taken;
    ms.insert(arr[0]);ms.insert(xx-arr[0]);taken.insert(arr[0]);
    cout<<*ms.rbegin()<<" ";
    for(int i=1;i<n;i++){
        auto t=taken.lower_bound(arr[i]);
        if(t==taken.end()||*t!=arr[i]){
            if(t==taken.end()){
                ll x=*taken.rbegin();
                ms.erase(ms.find(xx-x));
                ms.insert(xx-arr[i]);
                ms.insert(arr[i]-x);
            }else if(t==taken.begin()){
                ll x=*taken.begin();
                ms.erase(ms.find(x));
                ms.insert(x-arr[i]);
                ms.insert(arr[i]);
            }else{
                ll x=*t,y=*(--t);
                ms.erase(ms.find(x-y));
                ms.insert(x-arr[i]);
                ms.insert(arr[i]-y);
            }
            taken.insert(arr[i]);
        }
        cout<<*ms.rbegin()<<" ";

    }
    return 0;
}