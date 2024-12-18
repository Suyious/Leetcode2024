import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, i = 0, j = 0, res[] = new int[len - k + 1];
        Deque<Integer> q = new LinkedList<>();
        while(j < len) {
            if(j >= k) {
                if(!q.isEmpty() && q.getFirst() == i) q.removeFirst();
                i++;
            }

            while(!q.isEmpty() && nums[q.getLast()] < nums[j]) q.removeLast();
            q.addLast(j);

            if(j >= k - 1) res[i] = nums[q.getFirst()];
            j++;
        }
        return res;
    }

    public static void printArr(int [] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i != nums.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        printArr(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));  // [3,3,5,5,6,7]
        printArr(maxSlidingWindow(new int[]{7,2,5,4,8,3,1,6,2}, 3));  // [7,5,8,8,8,6,6]
        printArr(maxSlidingWindow(new int[]{4,5,2,5,6,2,5,6,4,3,5}, 4));  // [5,6,6,6,6,6,6,6]
        printArr(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));  // [3,3,2,5]
        printArr(maxSlidingWindow(new int[]{1}, 1));  // [1]
    }
}
