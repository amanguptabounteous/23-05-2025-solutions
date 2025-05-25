#include <bits/stdc++.h>
using namespace std;

string smallestsun(string s, string t){
    unordered_map<char, int> tar;
    unordered_map<char, int> curr;
    for(char x : t){
        tar[x]++;
    }
    int l = 0, r = 0, minl = 1000, start = 0;
    int val = 0;

    while(r<s.length()){
        char x = s[r++];
        if(tar.find(x)!=tar.end()){
            curr[x]++;
            if(curr[x]==tar[x]){
                val++;
            }
        }

        while(val==tar.size()){
            if(r-l<minl){
                minl = r - l;
                start = l;
            }
            char y = s[l++];
            if(tar.find(y)!=tar.end()){
                if(curr[y]==tar[y]){
                    val--;
                }
                curr[y]--;
            }
        }
    }

    if(minl==1000){
        return "";
    }

    string res = s.substr(start, minl);
    return res;
}

int main(){
    string s, t;
    cout << "Enter string: ";
    cin >> s;
    cout << "Enter target: ";
    cin >> t;
    cout << smallestsun(s, t);
    return 0;
}