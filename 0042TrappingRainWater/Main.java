public class Main {
    public static int trap(int[] height) {
        int n = height.length;
        if(n < 3) return 0;

        int i = 0, j = n - 1;
        int ml = 0, mr = n - 1;
        int vol = 0;

        while(i < j) {
            int w;
            if(height[i] > height[ml]) ml = i;
            if(height[j] > height[mr]) mr = j;
            if(height[ml] <= height[mr]) {
                w = height[ml] - height[i];
                i++;
            } else {
                w = height[mr] - height[j];
                j--;
            }
            if(w > 0) vol += w;
        }

        return vol;
    }

    public static void main(String[] args) { 
        System.out.println(trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
        System.out.println(trap(new int[]{1,2,3,0,2,1,5,2,3,0,2,4,0,8,0,3,1,6,2,4,1,2}));
        System.out.println(trap(new int[]{1,2,3,0,2,1,5,2,3,0,2,4,0,8,0,3,1,6,2,4,1,2,1}));
        System.out.println(trap(new int[]{1,2,3,1,2,3,5,0,1,2,0,1,0,3}));
    }
}