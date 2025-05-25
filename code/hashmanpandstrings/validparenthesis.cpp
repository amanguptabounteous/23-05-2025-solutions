#include <bits/stdc++.h>
using namespace std;

bool validpar(string s){
    unordered_map<char, char> mp = {{')','('}, {'}', '{'}, {']', '['}};
    stack<char> st;
    for(char x : s){
        if(x=='('||x=='{'||x=='['){
            st.push(x);
        }
        else{
            if(st.empty() || st.top()!=mp[x]){
                return false;
            }
            st.pop();
        }
    }
    return st.empty();
}

int main(){
    string s;
    cout << "Enter string: ";
    cin >> s;
    if(validpar(s)){
        cout << "Valid";
    }
    else{
        cout << "Invalid";
    }
    return 0;
}