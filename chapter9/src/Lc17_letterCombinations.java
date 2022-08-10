import java.util.ArrayList;
import java.util.List;

public class Lc17_letterCombinations {

    /**
     * 给定一个仅 仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     */
    public static String[] letterMap = {
        "",//0
        "",//1
        "abc",//2
        "def",//3
        "ghi",//4
        "jkl",//5
        "mno",//6
        "pqrs",//7
        "tuv",//8
        "wxyz"//9
    };

    static List<String> result = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    //index用来遍历题目输入的字符串
    public static void process(String digits, int index) {
        //base case
        if (index == digits.length()) {
            result.add(new String(path));
            return;
        }
        int digit = digits.charAt(index) - '0';//将index指向的字符转化为int类型
        String letters = letterMap[digit];//获取其对应的字符集
        for (int i = 0; i < letters.length(); i++) {
            //处理节点
            path.append(letters.charAt(i));
            //递归
            process(digits, index + 1);
            //回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return result;
        }
        process(digits,0);
        return result;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
}
