#include<bits/stdc++.h>
int main(){
    long long t,x,y;std::cin>>t;
    while(t--){
        std::cin>>x>>y;
        std::cout<<(((2*x-y)%3==0&&(2*y-x)%3==0&&2*x>=y&&2*y>=x)?"YES\n":"NO\n");
    }
    return 0;
}