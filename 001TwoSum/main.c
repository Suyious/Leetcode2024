#include <stdio.h>
#include <stdlib.h>

int comp(const void *, const void *);

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* answer = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;    // to be used in main

    // each pair in `results` stores nums[index], index
    int results[numsSize][*returnSize];

    for(int i = 0; i < numsSize; i++) {
        results[i][0] = nums[i];
        results[i][1] = i;
    }

    qsort(results, numsSize, sizeof(results[0]), comp);

    int i = 0, j = numsSize - 1;
    while(i < j) {
        int sum = results[i][0] + results[j][0];
        if(sum > target) {
            j--;
        } else if (sum < target) {
            i++;
        } else {
            answer[0] = results[i][1];
            answer[1] = results[j][1];
            break;
        }
    }

    return answer;
}

// Comparator function for qsort@[21]
int comp(const void * a, const void* b) {
    int* pair1 = (int*)a;
    int* pair2 = (int*)b;

    return pair1[0] - pair2[0];
}

int main() {
    int nums[] = {3, 3};
    int target = 6;
    int* returnSize = (int*)malloc(sizeof(int));

    int* answer = twoSum(nums, 4, target, returnSize);
    printf("[ %d, %d ]\n", answer[0], answer[1]);
    free(answer);
    free(returnSize);

    return 0;
}