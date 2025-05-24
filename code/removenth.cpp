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

void findnth(node* &l1, int k){
    node* front = l1;
    node* behind = l1;

    for(int i = 0; i<k; i++){
        if(front==nullptr){
            return;
        }
        front = front->next;
    }

    while(front->next){
        front = front->next;
        behind = behind->next;
    }

    node* tem = behind->next->next;
    behind->next = tem;

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
    int k;
    cout << "Enter nth position: ";
    cin >> k;
    node* l1 = createll(n1);
    findnth(l1, k);
    printll(l1);
}