import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int i = 0, j = 0, max = 0, maxFreq = 0;

        while(j < s.length()) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(j)));
            while((j - i + 1) - maxFreq - k > 0) {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                i++;
            }
            max = Math.max(max, (j - i + 1));
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));            //4
        System.out.println(characterReplacement("AABABBA", 1));         //4
        System.out.println(characterReplacement("XYUXXYYXUWVS", 3));    //6
    }
}
