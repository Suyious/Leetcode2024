import java.util.HashSet;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        int i = -1, j = 0, clength = 0, mlength = 0;
        HashSet<Character> letters = new HashSet<Character>();
        while(j < s.length()) {
            if(letters.contains(s.charAt(j))) {
                clength = 0;
                while(s.charAt(++i) != s.charAt(j)){
                    letters.remove(s.charAt(i));
                }
                j++;
            } else {
                letters.add(s.charAt(j));
                clength = j - i;
                j++;
            }
            if(clength > mlength) {
                mlength = clength;
            }
        }
        return mlength;
    }

    public static void main(String[] args) {
        String input = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
