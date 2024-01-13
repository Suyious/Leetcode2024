/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const size = nums.length;
    const answer = [0, 0];

    const result = nums.map((num, i) => [num, i]);
    result.sort((a, b) => a[0] - b[0]);

    i = 0, j = size - 1;
    while(i < j) {
        const sum = result[i][0] + result[j][0];
        if(sum > target) {
            j--;
        } else if(sum < target) {
            i++;
        } else  {
            answer[0] = result[i][1];
            answer[1] = result[j][1];
            break;
        }
    }

    return answer;
};

console.log(twoSum([2,7,11,15], 9));