#include <bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node* next;

    node(int val){
        data = val;
        next = NULL;
    }
};

node* reversell(node* head){
    node* newl = nullptr;
    while(head){
        node* tem = head->next;
        head->next = newl;
        newl = head;
        head = tem;
    }
    return newl;
}


void mergell(node* &head, int n){
    int mid = n/2; //we are using size of linked list to find mid in this case, if size not avalaibale we can find mid point through another function as well
    node* iter = head;
    node* midel = head;
    while(mid>0){
        midel = midel->next;
        mid--;
    }
    iter = midel;
    midel = midel->next;
    iter->next = NULL;
    midel = reversell(midel);
    iter = head;
    while(iter && midel){
        node* tim = iter->next;
        node* tim2 = midel->next;

        iter->next = midel;
        midel->next = tim;
        
        iter = tim;
        midel = tim2;
    }
}

node* createll(int n) {
    if (n <= 0) return nullptr;
    int val;
    cout << "Enter " << n << " integers:\n";
    cin >> val;
    node* head = new node(val);
    node* tail = head;

    for (int i = 1; i < n; ++i) {
        cin >> val;
        tail->next = new node(val);
        tail = tail->next;
    }

    return head;
}

void printll(node* head) {
    while (head) {
        cout << head->data;
        if (head->next)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main(){
    int n1;
    cin >> n1;
    node* l1 = createll(n1);
    mergell(l1, n1);
    printll(l1);
}