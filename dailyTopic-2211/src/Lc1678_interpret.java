public class Lc1678_interpret {

    /*
    1678. 设计 Goal 解析器
    请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
    Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
    然后，按原顺序将经解释得到的字符串连接成一个字符串。

    给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

    输入：command = "(al)G(al)()()G"
    输出："alGalooG"

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/goal-parser-interpretation
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String interpret(String command) {
        char[] arr = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == '(') {
                if (arr[index + 1] == 'a') {
                    sb.append("al");
                    index += 4;
                } else {
                    sb.append("o");
                    index += 2;
                }
            } else { //arr[index] == 'G'
                sb.append("G");
                index++;
            }
        }
        return sb.toString();
    }
}