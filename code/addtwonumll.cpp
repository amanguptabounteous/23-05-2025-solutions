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

node* addtwoll(node* l1, node* l2){
    node* resl = new node(0);
    node* head = resl;
    int carry = 0;
    while(l1!=nullptr || l2!=nullptr || carry>0){
        int x = carry;
        if(l1){
            x+= l1->data;
            l1 = l1->next;
        }
        if(l2){
            x+= l2->data;
            l2 = l2->next;
        }
        carry = x/10;
        resl->next = new node(x%10);
        resl = resl->next; 
    }
    return head->next;
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
    int n1, n2;
    cin >> n1;
    cin >> n2;
    node* l1 = createll(n1);
    node* l2 = createll(n2);
    node* l3 = addtwoll(l1, l2);
    printll(l3);
}