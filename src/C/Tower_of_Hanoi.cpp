#include<bits/stdc++.h>
using namespace std;
void solve(vector<pair<int,int>> &vec,int f,int t,int n ){
    if(n==1){
        vec.push_back({f+1,t+1});
    }else{
        int tmp=3-f-t;
        solve(vec,f,tmp,n-1);
        vec.push_back({f+1,t+1});
        solve(vec,tmp,t,n-1);
    }
}
int main(){
    int n;cin>>n;
    vector<pair<int,int>> vec;
    solve(vec,0,2,n);
    cout<<vec.size()<<"\n";
    for(auto x:vec){
        cout<<x.first<<" "<<x.second<<"\n";
    }
    return 0;
}