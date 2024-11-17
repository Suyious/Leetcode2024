import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> track = new HashSet<>();

        for(int x: nums) {
            track.add(x);
        }

        int current = 0;
        int maxLength = 1;

        for(int x: nums) {
            if(!track.contains(x - 1)) {
                int i = x + 1;
                current = 1;
                while(track.contains(i)) {
                    current++; i++;
                }
            }
            maxLength = Math.max(maxLength, current);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 0, 1, 2, 4, 5, 6, 7, 8, 10 }));
        System.out.println(longestConsecutive(new int[] {}));
    }
}
