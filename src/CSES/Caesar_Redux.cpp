#include<bits/stdc++.h>

using namespace std;

#define FAST ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define rall(v) (v).rbegin(), (v).rend()

void solve(){
    
}

int main(){
    string t;
    getline(cin, t);
    int tt = stoi(t);
    for(int j = 0; j < tt; j++){
        string m;
        string s;
        getline(cin, m);
        int n = stoi(m);
        getline(cin, s);
        bool ok = 0;
        for(int i = 0; i + 2 < sz(s); i++){
            if(s[i] == 't' && s[i + 1] == 'h' && s[i + 2] == 'e'){
                if(i == 0){
                    if(i + 3 == sz(s)) ok = 1;
                    else if(s[i + 3] == ' ') ok = 1;
                }
                else{
                    if(i + 3 == sz(s) && s[i - 1] == ' ') ok = 1;
                    else if(s[i + 3] == ' ' && s[i - 1] == ' ') ok = 1;
                }
            }
        }
        for(int i = 0; i < sz(s); i++){
            if(!isalpha(s[i])) continue;
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
        while(sz(s) && !isalpha(s.back())) s.pop_back();
        cout << s;
        if(j != tt - 1) cout << '\n';
    }
    return 0;
}