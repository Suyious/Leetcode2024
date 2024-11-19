import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        int i, j, k;
        for (i = 0; i < n; i++) {
            if(nums[i] > 0) break;  // positive triplets cannot add to 0
            while(i > 0 && i < n && nums[i] == nums[i - 1]) i++;
            j = i + 1;
            k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                }
                if (sum > 0) k--;
                if (sum < 0) j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
