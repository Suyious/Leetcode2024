public class Main {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = postfix * ans[i];
            postfix = postfix * nums[i];
        }

        return ans;
    }

    public static void printArr(int[] nums) {
        for(int x: nums) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArr(productExceptSelf(new int[]{1, 2, 3, 4}));
        printArr(productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
}
