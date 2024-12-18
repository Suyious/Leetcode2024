import java.util.Stack;

public class Main {

    public static char close(char c) {
        if(c == '(') return ')';
        else if(c == '[') return ']';
        else return '}';
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty() || close(stack.peek()) != s.charAt(i)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("{[{{}{}()}{}]}")); // true
        System.out.println(isValid("{[{{}}(}{}]}")); // false
    }
}
