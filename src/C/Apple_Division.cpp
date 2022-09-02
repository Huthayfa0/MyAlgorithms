#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;cin>>n;
    long long s=0;
    long long best=numeric_limits<long long>::max();
    long long arr[n];for(int i=0;i<n;i++){cin>>arr[i];s+=arr[i];}
    for(int i=0;i<(1<<n);i++){
        long long cur=0;
        for(int j=0;j<n;j++){
            if(i&(1<<j))cur+=arr[j];
        }
        best=min(best,abs(s-2*cur));
    }
    cout<<best;
    return 0;
}