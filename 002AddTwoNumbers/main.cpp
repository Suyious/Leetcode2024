#include <cstdio>

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    int carry = 0;
    ListNode *i = l1, *j = l2;
    ListNode *result = new ListNode();
    ListNode *k = result;
    // if either is null, stop
    while(i != nullptr && j != nullptr) {
        int sum = i->val + j->val + carry;
        carry = sum / 10;
        k->val = sum % 10;
        i = i->next;
        j = j->next;
        // if either is not nullptr, do
        if(i != nullptr || j != nullptr) {
          k->next = new ListNode();
          k = k->next;
        }
    }
    while(i != nullptr) {
        int sum = i->val + carry;
        carry = sum / 10;
        k->val = sum % 10;
        i = i->next;
        if(i != nullptr) {
          k->next = new ListNode();
          k = k->next;
        }
    }
    while(j != nullptr) {
        int sum = j->val + carry;
        carry = sum / 10;
        k->val = sum % 10;
        j = j->next;
        if(j != nullptr) {
          k->next = new ListNode();
          k = k->next;
        }
    }
    if(carry != 0) {
        k -> next = new ListNode(carry);
    }
    return result;
}

ListNode *arrayToList(int arr[], int size) {
    ListNode *head = new ListNode(arr[0]);
    ListNode* iter = head;
    for (int i = 1; i < size; i++) {
        ListNode *l = new ListNode(arr[i]);
        iter->next = l;
        iter = l;
    }
    return head;
}

void printl(ListNode *l) {
    ListNode* iter = l;
    while(iter != nullptr) {
      printf("%d ", iter->val);
      iter = iter->next;
    } printf("\n");
}

int main(){
    int input1[] = {1, 2, 8, 9};
    int input2[] = { 5, 6, 4 };
    ListNode* input1List = arrayToList(input1, 4);
    ListNode* input2List = arrayToList(input2, 3);
    printl(input1List);
    printl(input2List);
    ListNode* result = addTwoNumbers(input1List, input2List);
    printl(result);
    return 0;
}