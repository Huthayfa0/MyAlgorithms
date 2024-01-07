#include<bits/stdc++.h>
using namespace std;
#define MX 100001
#define inF freopen("here_comes_santa_claus_input.txt", "r", stdin);
#define outF freopen("out", "w", stdout);
int main(){
    ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
   // inF
   // outF
    int t;cin>>t;
    long long arr[MX];

    for(int _=1;_<=t;_++){
        int n;cin>>n;
        if(n<=41){
            cout<<"Case #"<<_<<": "<<n;
            for(int i=0;i<41-n;i++)cout<<" 1";cout<<"\n";
            continue;
        }
        vector<int> primes;
        vector<int> ans;
        int i=2;
        while(n!=1){
            if(n%i){
                i++;
            }else{
                n/=i;
                primes.push_back(i);
            }
            if(i>41)break;
        }
        if(n!=1){
            ans={-1};
        }else{
            int s=0;
            for(auto x:primes)s+=x;
            if(s>41){
                ans={-1};
            }else{
                //2, 3, 5, 7, 11, 13, 17, 19
                
            }
        }
        cout<<"Case #"<<_<<": ";
        for(auto x:ans)cout<<x<<" ";cout<<"\n";
    }
}
