#include <bits/stdc++.h>
using namespace std;

vector<vector<string>> groupana(vector<string>& str) {
    unordered_map<string, vector<string>> mp;
    for (string x : str) {
        string k = x;
        sort(k.begin(), k.end());
        mp[k].push_back(x);
    }
    vector<vector<string>> res;
    for (auto i : mp) {
        res.push_back(i.second);
    }
    return res;
}

int main(){
    vector<string> str = {"rat", "tar", "art", "car", "arc"};
    vector<vector<string>> ans = groupana(str);

    for(auto x : ans){
        for(auto y : x){
            cout << y << " ";
        }
        cout << endl;
    }
}
