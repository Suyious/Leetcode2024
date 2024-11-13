def twoSum(nums, target):
    size = len(nums)
    answer = ()

    results = [(num, i) for i, num in enumerate(nums)]
    results.sort(key= lambda x: x[0])
    print(results)

    i = 0
    j = size - 1
    while i < j:
        sum = results[i][0] + results[j][0]
        if sum > target:
            j = j - 1
        elif sum < target:
            i = i + 1
        else:
            answer = (results[i][1], results[j][1])
            break
    
    return answer

if __name__ == "__main__":
    print(twoSum([3,2,3], 6))