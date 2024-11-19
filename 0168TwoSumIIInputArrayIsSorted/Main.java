public class Main {
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;

        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[]{ i + 1, j + 1};
            if(sum < target) i++;
            if(sum > target) j--; 
        }

        return new int[]{i + 1, j + 1};
    }

    public static void test(int[] numbers, int target) {
        int[] ans = twoSum(numbers, target);
        System.out.println("[" + ans[0] + "," + ans[1] + "]");
    }

    public static void main(String[] args) {
        test(new int[]{2,7,11,15}, 9);
        test(new int[]{2,3,4}, 6);
        test(new int[]{-1,0}, -1);
    }
}
