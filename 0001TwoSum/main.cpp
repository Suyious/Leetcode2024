#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;

vector<int> twoSum(vector<int> &nums, int target) {
    int size = nums.size();
    vector<int> answers(2);

    // pair `results` stores { nums[index], index }
    vector<pair<int, int>> results(size);
    for(int i = 0; i < size; i++) {
        results[i] = { nums[i], i };
    }

    sort(results.begin(), results.end(), [](pair<int, int> p1, pair<int, int> p2) { return p1.first < p2.first; });

    int i = 0, j = size - 1;
    while(i < j) {
        int sum = results[i].first + results[j].first;
        if(sum > target) {
            j--;
        } else if(sum < target) {
            i++;
        } else {
            answers = { results[i].second, results[j].second };
            break;
        }
    }

    return answers;
}

int main() {
    vector<int> nums = {3, 3};
    int target = 6;
    vector<int> answer = twoSum(nums, target);
    cout<<"[";
    cout<<" " << answer[0] << ", " << answer[1] << " ";
    cout<<"]\n";
    return 0;
}