#include <bits/stdc++.h>
using namespace std;

bool containsAnagram(string s, string t) {
    if (t.length() > s.length()) return false;

    vector<int> tar(26, 0), curr(26, 0);

    for (char c : t){ 
        tar[c - 'a']++;
    }
    for (int i = 0; i < s.length(); ++i) {
        curr[s[i] - 'a']++;
        if (i >= t.length()) {
            curr[s[i - t.length()] - 'a']--;
        }

        if (curr == tar) return true;
    }

    return false;
}

int main() {
    string s, t;
    cout << "Enter string: ";
    cin >> s;
    cout << "Enter pattern: ";
    cin >> t;

    if (containsAnagram(s, t)) {
        cout << "True";
    } else {
        cout << "False";
    }

    return 0;
}
