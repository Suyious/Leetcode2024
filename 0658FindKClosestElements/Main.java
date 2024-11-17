import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer[]> diffs = new PriorityQueue<>(k, (a, b) -> b[0] == a[0] ? b[1] - a[1]: b[0] - a[0]);
        for(int elem: arr) {
            diffs.add(new Integer[]{Math.abs(elem - x), elem});
            if(diffs.size() > k) {
                diffs.poll();
            }
        }
        List<Integer> ans = new ArrayList<Integer>(diffs.stream().map(diff -> diff[1]).toList());
        ans.sort(null);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,1,2,3,4,5}, 4, -1));
    }
}
