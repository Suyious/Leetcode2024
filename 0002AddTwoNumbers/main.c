#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};
struct ListNode* newl(int val, struct ListNode* next);
void deletel(struct ListNode* l);

// Constructor for singly linked list
struct ListNode* newl(int val, struct ListNode* next) {
    struct ListNode* l = malloc(sizeof(struct ListNode));
    l->val = val;
    l->next = next;
    return l;
}

// Destructor for singly linked list
void deletel(struct ListNode* l) {
    if(l) {
        deletel(l->next);
        free(l);
    }
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *i = l1, *j = l2;
    int carry = 0;
    struct ListNode *s = NULL;
    struct ListNode *k;

    while(i != NULL || j != NULL || carry != 0) {
        int sum = carry;

        if(i != NULL) {
            sum += i->val;
            i = i->next;
        }

        if(j != NULL) {
            sum += j->val;
            j = j->next;
        }

        if(s == NULL) {
            s = newl(sum % 10, NULL);
            k = s;
        } else {
            k->next = newl(sum % 10, NULL);
            k = k->next;
        }
        carry = sum / 10;
    }

    return s;
};

// One Dimentional Array to Singly linked list
struct ListNode* artol(int a[], int size) {
    struct ListNode* l = NULL;
    if(size > 0) {
      l = newl(a[0], NULL);
      struct ListNode *p = l;
      for (int i = 1; i < size; i++) {
        struct ListNode* t = newl(a[i], NULL);
        p->next = t;
        p = t;
      }
    }
    return l;
}

// print singly linked list
void printl(struct ListNode* l) {
    if(l != NULL){
        printf("%d ", l->val);
        printl(l->next);
    } else {
        printf("\n");
    }
}

int main() {
    int a[] = {1, 2, 3, 4, 5};
    int b[] = {2, 4, 6, 8, 9};
    struct ListNode* l1 = artol(a, 5);
    struct ListNode* l2 = artol(b, 5);
    struct ListNode *sum = addTwoNumbers(l1, l2);
    printl(l1);
    printl(l2);
    printl(sum);
    deletel(l1);
    deletel(l2);
    deletel(sum);

    return 0;
}