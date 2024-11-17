import java.util.HashSet;

public class Main {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int x: nums) {
            if(!hashSet.add(x)) {
                return true;
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        boolean ans = containsDuplicate(new int[]{1,2,3,3});
        System.out.println(ans);
    }
}