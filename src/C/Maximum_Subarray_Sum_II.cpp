#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll n,a,b;cin>>n>>a>>b;ll arr[n+1],sum[n+1];sum[0]=0;for(int i=1;i<=n;i++){cin>>arr[i];sum[i]=arr[i]+sum[i-1];}
    multiset<ll> st;
    ll ans=numeric_limits<ll>::min();
    for(int i = a; i <= n; ++i) {
		if(i > b) st.erase(st.find(sum[i-b-1]));
		st.insert(sum[i-a]);
		ans = max(ans, sum[i]-*st.begin());
	}
    cout<<ans;
    return 0;
}