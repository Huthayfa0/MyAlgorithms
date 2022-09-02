#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll ans=0,n;cin>>n;
    ll pre,cur;cin>>pre;n--;
    while(n--){
        cin>>cur;
        if(cur<pre){
            ans+=pre-cur;
            cur+=pre-cur;
        }
        pre=cur;
    }
    cout<<ans;
    
    return 0;
}