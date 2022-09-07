#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll MAX=2e5+10;
    set<ll> s;map<ll,ll> nums;
    ll n;cin>>n;pair<pair<ll,ll>,ll> arr[n];ll a[n],b[n];
    for(ll i=0;i<n;i++){
        cin>>arr[i].first.first>>arr[i].first.second;arr[i].first.second*=-1;arr[i].second=i;
        a[i]=0;b[i]=0;
        s.insert(-arr[i].first.second);
    }   
    ll cnt=1;
    for(auto x:s){
        nums[x]=cnt++;
    }
    sort(arr,arr+n);
    ll BIT[MAX];for(ll i=0;i<MAX;i++){
        BIT[i]=0;
    }
    for(ll i=n-1;i>=0;i--){
        ll ind=arr[i].second;
        ll x;

        x=nums[-arr[i].first.second];
        while(x>0){

            a[ind]+=BIT[x];
            x-=x&(-x);
        }

        x=nums[-arr[i].first.second];
        while(x<MAX){
            BIT[x]++;
            x+=x&(-x);
        }
    }  
    for(ll i=0;i<MAX;i++){
        BIT[i]=0;
    }
    for(ll i=0;i<n;i++){
        ll ind=arr[i].second;
        ll x;
        x=MAX-1;
        while(x>0){

            b[ind]+=BIT[x];
            x-=x&(-x);
        }
        x=nums[-arr[i].first.second]-1;
        while(x>0){

            b[ind]-=BIT[x];
            x-=x&(-x);
        }
        x=nums[-arr[i].first.second];
        while(x<MAX){
            BIT[x]++;
            x+=x&(-x);
        }
    }  
    
    for(ll i=0;i<n;i++)cout<<a[i]<<" ";
    cout<<"\n";
for(ll i=0;i<n;i++)cout<<b[i]<<" ";
    return 0;
}