# 002. Add Two Numbers

[Leetcode](https://leetcode.com/problems/add-two-numbers)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Intuition

- Use pointer `i` at the head of first linked-list and `j` at that of the second.
- Use `k` to start forming a new linked-list to store the sum. We will keep track of the head of the new linked-list using `s` to be returned at the end.
- Use a variable `carry` to keep track of carried over values. Initialize it with `0`;
- Iterate through both the linked-lists to add up the values at each node and the `carry`:
    - initiaize a variable `sum` with `carry`
    - Check if `i` is `NULL` and if not, add it's value to `sum` and assign `i` to `i->next`
    - Check if `j` is `NULL` and if not, add it's value to `sum` and assign `j` to `j->next`
    - Now, if it's the first iteration, `s` needs to be initialized as a new linked-list with value as the unit's digit of `sum` and `k` should point to `s`.
    - In further iterations, `k->next` needs to store a new node with the value as the unit's digit of `sum` and `k` should be changed to `k->next`
    - `carry` should be changed to the rest of the digits leaving the unit's digit in sum.

### Solutions:

- **C**:            [Code](./main.c)
- **C++**:          [Code](./main.cpp)
- **Java**:         [Code](./Main.java)
- **Python**:       [Code](./main.py)
- **Javascript**:   [Code](./main.js)
- **Rust**:         [Code](./main.rs)
- **Go**:           [Code](./main.go)