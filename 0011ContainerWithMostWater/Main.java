public class Main {
    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;

        int maxArea = Integer.MIN_VALUE;
        while(i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if(height[i] < height[j]) i++; else j--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
       System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
