import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Lc1106_parseBoolExpr {

    /*
    1106. 解析布尔表达式
    给你一个以字符串形式表述的布尔表达式（boolean） expression，返回该式的运算结果。
    有效的表达式需遵循以下约定：

    "t"，运算结果为 True
    "f"，运算结果为 False
    "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
    "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
    "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）

    输入：expression = "!(f)"
    输出：true
    输入：expression = "|(&(t,f,t),!(t))"
    输出：false

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/parsing-a-boolean-expression
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean parseBoolExpr(String expression) {
        //Stack<Character> stack = new Stack<>();
        Deque<Character> stack = new ArrayDeque<>(); //用这个会比stack快9ms？？？？
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') { //如果当前字符是逗号，则跳过该字符；
                continue;
            } else if (c != ')') { //如果当前字符是除了逗号和右括号以外的任意字符，则将该字符添加到栈内；
                stack.push(c);
            } else { //如果当前字符是右括号，则一个表达式遍历结束，需要解析该表达式的值，并将结果添加到栈内：
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop(); //弹出左括号
                char op = stack.pop(); //运算符
                switch (op) {
                    case '!':
                        stack.push(f == 1 ? 't' : 'f');
                        break;
                    case '&': //运算符是 & ,若出现false，当前结果就是false，放入栈中
                        stack.push(f == 0 ? 't' : 'f');
                        break;
                    case '|': //运算符是 | ,若出现true，当前结果就是false，放入栈中
                        stack.push(t > 0 ? 't' : 'f');
                        break;
                    default:
                }
            }
        }
        return stack.pop() == 't';
    }
}
