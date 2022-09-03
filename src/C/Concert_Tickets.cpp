#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,m;
    cin>>n>>m;
    ll b[m];
    map<ll,ll> a;
    for(int i=0;i<n;i++){
        ll z;cin>>z;a[z]++;
    }
    for(int i=0;i<m;i++)cin>>b[i];
    for(int i=0;i<m;i++){
        if(a.size()==0){
            cout<<"-1\n";
            continue;
        }
    auto t=a.lower_bound(b[i]);
    if(t==a.end())t--;
    //cout<<(*t).first<<" "<<(*t).second<<"\n";
    if(t==a.begin()&&(*t).first>b[i]){
        cout<<-1;
    }else{
        if((*t).first>b[i]){
            t--;
        }
        cout<<(*t).first;
        (*t).second--;
        if((*t).second==0){
            a.erase((*t).first);
        }    
    }
    cout<<"\n";
    }

    
        
    return 0;
}