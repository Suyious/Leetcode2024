public class Main {

    public static boolean checkInclusion(String p, String s) {
        if(s.length() < p.length()) return false;
        int pfreq[] = new int[26]; // character frequency in p
        int sfreq[] = new int[26]; // character frequency in s

        // Calculate frequencies in p and first window of s
        for(int i = 0; i < p.length(); i++) {
            pfreq[p.charAt(i) - 'a']++;
            sfreq[s.charAt(i) - 'a']++;
        }

        int match = 0;
        // Calculate initial match in first window
        for(int i = 0; i < 26; i++) {
            if(pfreq[i] == sfreq[i]) match++;
        }

        int l = 0, r = p.length();
        while(r < s.length()) {

            // if all matches are found, return true
            if(match == 26) return true;

            int charAtr = s.charAt(r) - 'a';
            int charAtl = s.charAt(l) - 'a';

            // if character at r has same frequency in p and s
            // before addition to window, match--
            // as it will lose a match after addition
            if(pfreq[charAtr] == sfreq[charAtr]) match--;

            // add character at r to window
            sfreq[charAtr]++;

            // if character at r has same frequency in p and s
            // after addition to window, match++
            if(pfreq[charAtr] == sfreq[charAtr]) match++;
            
            // if character at r has same frequency in p and s
            // before removal to window, match--
            if(pfreq[charAtl] == sfreq[charAtl]) match--;

            // add character at r to window
            sfreq[charAtl]--;

            // if character at r has same frequency in p and s
            // after removal to window, match++
            if(pfreq[charAtl] == sfreq[charAtl]) match++;

            // move sliding window
            l++;r++;
        }

        return match == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));       // true
        System.out.println(checkInclusion("ab", "eidboaoo"));       // false
        System.out.println(checkInclusion("abc", "ebaciooo"));      // true
        System.out.println(checkInclusion("abc", "ebacicba"));      // true
    }
}
