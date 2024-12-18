import java.util.HashMap;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        int i = -1, j = 0, len = 0;
        HashMap<Character, Integer> letters = new HashMap<>();
        while(j < s.length()) {
            if(letters.containsKey(s.charAt(j))) {
                i = Math.max(i, letters.get(s.charAt(j)));
            }
            letters.put(s.charAt(j), j);
            len = Math.max(j - i, len);
            j++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt")); // 5
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("abbcaccabdac")); // 4
    }
}
