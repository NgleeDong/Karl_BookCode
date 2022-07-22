import java.util.Stack;

public class Lc150_evalRPN {

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 注意两个整数之间的除法只保留整数部分。
     * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     */
    public static int evalRPN(String[] tokens) {

        //准备一个栈，存放"数"和当点已计算的值
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                //取出栈中的数值
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+": stack.push(num2 + num1); break;
                    case "-": stack.push(num2 - num1); break;
                    case "*": stack.push(num2 * num1); break;
                    case "/": stack.push(num2 / num1); break;
                }
            } else {
                //否则肯定是数字了,压栈就可以
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static int evalRPN1(String[] tokens) {

        //准备一个栈，存放"数"和当点已计算的值
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                //取出栈中的数值
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+": stack.push(num2 + num1); break;
                    case "-": stack.push(num2 - num1); break;
                    case "*": stack.push(num2 * num1); break;
                    case "/": stack.push(num2 / num1); break;
                }
            } else {
                //否则肯定是数字了,压栈就可以
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        System.out.println(evalRPN1(tokens));

        String[] tokens1 = {"4","13","5","/","+"};
        System.out.println(evalRPN1(tokens1));

    }
}
