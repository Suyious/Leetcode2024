package main

import (
	"fmt"
	"slices"
	"cmp"
)

func twoSum(nums []int, target int) []int {
	size := len(nums)
	answer := []int{0, 0}
	result := make([][2]int, size)
	for i, num := range(nums) {
		result[i] = [2]int{num, i}
	}
	slices.SortFunc(result, func(a, b [2]int) int {
		return cmp.Compare(a[0], b[0])
	})
	i := 0
	j := size - 1
	for i < j {
		sum := result[i][0] + result[j][0]
		if sum > target {
			j--
		} else if sum < target {
			i++
		} else {
			answer[0] = result[i][1]
			answer[1] = result[j][1]
			break
		}
	}

	return answer
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}
