public class Main {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;

        while(i < j) { 
            while(i < n - 1 && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(i > n - 1 || j < 0) return true;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));
    }
}