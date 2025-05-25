#include <bits/stdc++.h>
using namespace std;

bool closestring(string s, string t){
    unordered_set<char> s1(s.begin(), s.end());
    unordered_set<char> s2(t.begin(), t.end());
    return (s1==s2 && s.length() == t.length());
}

int main(){
    string s, t;
    cout << "Enter string: ";
    cin >> s;
    cout << "Enter target: ";
    cin >> t;
    if(closestring(s,t)){
        cout << "True";
    }
    else{
        cout << "False";
    }
}