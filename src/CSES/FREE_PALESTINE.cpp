#include<bits/stdc++.h>

using namespace std;

#define int long long
#define FAST ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define rall(v) (v).rbegin(), (v).rend()

void solve(){
    int n;
    string s;
    cin >> n;
    getline(cin, s);
    getline(cin, s);
    bool ok = 0;
    for(int i = 0; i + 2 < sz(s); i++){
        if(s[i] == 't' && s[i + 1] == 'h' && s[i + 2] == 'e'){
            if(i + 3 == sz(s)) ok = 1;
            else{
                if(s[i + 3] == ' ') ok = 1;
            }
        }
    }
    for(int i = 0; i < sz(s); i++){
        if(s[i] == ' ') continue;
        if(!ok){
            int N = n;
            while(N--){
                s[i]++;
                if(s[i] > 'z') s[i] = 'a';
            }
        }
        else{
            s[i] -= n;
            if(s[i] < 'a'){
                s[i] += 26;
            }
        }
    }
    cout << s << '\n';
}

int32_t main(){
    FAST
    int tt = 1;
    cin >> tt;
    while(tt--){
        solve();
    }
    return 0;
}