#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n;cin>>n;
    ll arr[n];
    for(ll i=0;i<n;i++)cin>>arr[i];
    set<ll>tmp,ans;
    ans.insert(0);
    for(int i=0;i<n;i++){
        for(auto x:ans){
            tmp.insert(x+arr[i]);

        }
        for(auto x:tmp){
            ans.insert(x);

        }
        tmp.clear();
    }
    ans.erase(ans.begin());
    cout<<ans.size()<<endl;
    for(auto x:ans){
        cout<<x<<" ";
    }
    return 0;
}