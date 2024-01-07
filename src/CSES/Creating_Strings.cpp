#include<bits/stdc++.h>
using namespace std;
int main(){
    string x;cin>>x;
    vector<string>s;
    sort(x.begin(),x.end());
    do{
        s.push_back(x);
    }while(next_permutation(x.begin(),x.end()));
    cout<<s.size()<<"\n";
    for(auto a:s){
        cout<<a<<"\n";
    }
    return 0;
}