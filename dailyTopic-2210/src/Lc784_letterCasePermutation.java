import java.util.ArrayList;
import java.util.List;

public class Lc784_letterCasePermutation {

    /*
    784. 字母大小写全排列

    给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。

    返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。

    测试用例：
    输入：s = "a1b2"
    输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     */


    /**
     * 回溯
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, res);
        return res;
    }

    public static void dfs(char[] str, int index, List<String> res) {
        while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
            index++;
        }
        if (index == str.length) {
            //收集结果
            res.add(String.valueOf(str));
            return;
        }
        // str[index]位置为字母
        //原来是大写 or 小写
        dfs(str, index + 1, res);
        //大写转小写 or  小写转大写
        if (str[index] >= 'a' && str[index] <= 'z') {
            str[index] -= 32;
        } else { //如果输入的是大写，+32即可得到小写
            str[index] += 32;
        }
        dfs(str, index + 1, res);
    }

    public static void main(String[] args) {
        char c = 'A';
        c += 32;
        System.out.println("c = " + c);
    }
}
