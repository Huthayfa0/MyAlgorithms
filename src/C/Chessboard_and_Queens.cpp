#include<bits/stdc++.h>
using namespace std;
string arr[8];
bool y[8],dl[15],dr[15];
void calc(long long &s,int n){
    if(n==8)s++;
    else{
        for(int i=0;i<8;i++){
            if(y[i]||arr[n][i]=='*'||dl[n-i+7]||dr[7-i-n+7])continue;
            y[i]=dl[n-i+7]=dr[7-i-n+7]=1;
            calc(s,n+1);
            y[i]=dl[n-i+7]=dr[7-i-n+7]=0;
        }

    }
}
int main(){
    for(int i=0;i<8;i++)cin>>arr[i];
    long long s=0;
    for(int i=0;i<8;i++)y[i]=0;
    for(int i=0;i<15;i++)dl[i]=dr[i]=0;
    calc(s,0);
    cout<<s;
    return 0;
}