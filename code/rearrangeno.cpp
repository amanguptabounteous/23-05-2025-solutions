#include <bits/stdc++.h>
using namespace std;

int minper(int num){
    vector<int> numcount(10, 0);
    while(num>=1){
        int x = num%10;
        num = num/10;
        numcount[x]++;
    }
    int n = 0;
    for(int i = 1; i<10; i++){
       while(numcount[i]>0){
        n = n*10 + i;
        numcount[i]--;
       } 
    }
    return n;
}

int main(){
    cout << minper(110201781);
}