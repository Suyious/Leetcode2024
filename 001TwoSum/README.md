# 001 Two Sum 

[Leetcode](https://leetcode.com/problems/two-sum/)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

### Intuition

- Create an array `pairs` with the element-index pair to keep track of the original array `nums`
- Sort the new array `pairs` with the element-index pair in ascending order of the element
- Use two pointers `i` (at the beginning of `pairs`) and `j` (at the end of `pairs` i.e., len - 1)
- If the sum of the elements at `i` and `j` is greater than `target`, we decrement `j`
- If the sum of the elements at `i` and `j` is less than `target`, we increment `i`
- The above two steps repeat till the elements at `i` and `j` sum up to exactly `target`, at which point we return the indexes stored at `i` and `j`

### Solutions:

- **C**:            [Code](./main.c)
- **C++**:          [Code](./main.cpp)
- **Java**:         [Code](./Main.java)
- **Python**:       [Code](./main.py)
- **Javascript**:   [Code](./main.js)
- **Rust**:         [Code](./main.rs)
- **Go**:           [Code](./main.go)
