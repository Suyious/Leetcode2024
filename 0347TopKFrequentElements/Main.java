import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        freq.forEach((Integer element, Integer frequency) -> {
            heap.offer(new int[] { frequency, element });
            if (heap.size() > k) {
                heap.poll();
            }
        });

        return heap.stream().mapToInt(elem -> elem[1]).toArray();
    }

    public static void test(int[] nums, int k) {
        int[] ans = topKFrequent(nums, k);
        for (int x : ans) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        test(new int[] { 1 }, 1);
    }
}
