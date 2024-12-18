import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String minWindow(String s, String t) {
        int req = t.length();
        int len = s.length();
        if(len < req) return "";

        Map<Character, Integer> requirement = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < req; i++) {
            requirement.put(t.charAt(i), requirement.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int min_len = Integer.MAX_VALUE;
        int[] index = {-1, -1};
        int has = 0, need = requirement.size();

        while(r < len) {

            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(requirement.containsKey(c) && requirement.get(c).equals(window.get(c))) {
                has++;
            }

            while(has == need) {
                if((r - l + 1) < min_len) {
                    index[0] = l;
                    index[1] = r;
                    min_len = r - l + 1;
                }
                c = s.charAt(l);
                window.put(c, window.getOrDefault(c, 0) - 1);

                if(requirement.containsKey(c) && window.get(c) < requirement.get(c)) {
                    has--;
                }
                l++;
            }

            r++;
        }

        return min_len == Integer.MAX_VALUE ? "" : s.substring(index[0], index[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));  // "BANC"
        System.out.println(minWindow("a", "a"));                //  "a"
        System.out.println(minWindow("a", "aa"));               //  ""
    }
}
