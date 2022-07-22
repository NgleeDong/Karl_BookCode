import java.util.Stack;

public class Lc20_isValid {

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        //准备一个栈
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() == '(') continue;
                return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() == '{') continue;
                return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() == '[') continue;
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        char[] arr = s.toCharArray();
        //准备一个栈
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if ( c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid1(s));
    }
}
