#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
 
int main(){
    ll n,N,q;cin>>n>>q;N=1;
    while(N<n)N<<=1;
    
    ll tree[2*N]={0},lzset[2*N]={0},lzadd[2*N]={0};

    for(ll i=0;i<n;i++){cin>>tree[i+N];}
    for(ll i=N-1;i>0;i--){
        tree[i]=tree[2*i]+tree[2*i+1];
    }
    auto pull=[&](ll i){
        tree[i]=tree[i*2]+tree[i*2+1];
    };
    auto push=[&](ll i,ll l,ll m,ll r){
        if(lzset[i]){
            lzset[2*i]=lzset[2*i+1]=lzset[i];
            tree[2*i]=(m-l+1)*lzset[i];
            tree[2*i+1]=(r-m)*lzset[i];
            lzadd[2*i]=lzadd[2*i+1]=0;
            lzset[i]=0;
        }else if(lzadd[i]){
            if(lzset[2*i]==0)lzadd[2*i]+=lzadd[i];
            else{
                lzset[2*i]+=lzadd[i];
                lzadd[2*i]=0;
            } 
            if(lzset[2*i+1]==0)lzadd[2*i+1]+=lzadd[i];
            else{
                lzset[2*i+1]+=lzadd[i];
                lzadd[2*i+1]=0;
            } 
            tree[2*i]+=(m-l+1)*lzadd[i];
            tree[2*i+1]+=(r-m)*lzadd[i];
            lzadd[i]=0;
        }
        return;
    };
    function<void(ll,ll,ll,ll,ll,ll)> add=[&](ll i,ll l,ll r,ll s,ll e,ll v){
        if(e<l||r<s)return;
        if(e>=r&&s<=l){
            tree[i]+=(r-l+1)*v;
            if(lzset[i])lzset[i]+=v;
            else lzadd[i]+=v;
        }else{
            ll m=(l+r)>>1;
            push(i,l,m,r);
            add(i*2,l,m,s,e,v);
            add(i*2+1,m+1,r,s,e,v);
            pull(i);
        }
    };
    function<void(ll,ll,ll,ll,ll,ll)> set=[&](ll i,ll l,ll r,ll s,ll e,ll v){
        if(e<l||r<s)return;
        if(e>=r&&s<=l){
            tree[i]=(r-l+1)*v;
            lzset[i]=v;
            lzadd[i]=0;
        }else{
            ll m=(l+r)>>1;
            push(i,l,m,r);
            set(i*2,l,m,s,e,v);
            set(i*2+1,m+1,r,s,e,v);
            pull(i);
        }
    };
    function<ll(ll,ll,ll,ll,ll)> query=[&](ll i,ll l,ll r,ll s,ll e){
        if(e<l||r<s)return 0LL;
        if(e>=r&&s<=l){
            return tree[i];
        }else{
            ll m=(l+r)>>1;
            push(i,l,m,r);
            return query(i*2,l,m,s,e)+query(i*2+1,m+1,r,s,e);
        }
    };
    
 
    for(ll i = 1; i <= q; ++i){
		ll k; cin >> k;
		ll a,b,x;
		if(k == 1){
			cin >> a >> b >> x;
			add(1,1,N,a,b,x);
		}
		if(k == 2){
			cin >> a >> b >> x;
			set(1,1,N,a,b,x);
		}
		if(k == 3){
			cin >> a >> b;
			ll res = query(1,1,N,a,b);
			cout << res << '\n';
		}
	}
    return 0;
}