import java.util.Arrays;

public class Main {
    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int answer[] = {0, 0};

        int[][] results = new int[size][2];
        for(int i = 0; i < size; i++) {
            results[i][0] = nums[i];
            results[i][1] = i;
        }

        Arrays.sort(results, (int[] a, int[] b) -> a[0] - b[0]);

        int i = 0, j = size - 1;
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

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] answer = twoSum(nums, 9);
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");
    }
}