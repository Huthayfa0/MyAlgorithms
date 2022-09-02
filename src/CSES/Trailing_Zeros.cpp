#include<bits/stdc++.h>
int main(){
    long long n,ans=0;std::cin>>n;
    while(n>0)ans+=(n/=5);
    std::cout<<ans;
    return 0;
}