import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s: strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String ns = new String(cs);

            if(!anagrams.containsKey(ns)) {
                anagrams.put(ns, new ArrayList<>());
            }

            anagrams.get(ns).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        int[] count = new int[26];
        System.out.println(Arrays.toString(count));
    }
}
