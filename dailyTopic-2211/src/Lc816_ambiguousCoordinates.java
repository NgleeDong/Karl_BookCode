import java.util.ArrayList;
import java.util.List;

public class Lc816_ambiguousCoordinates {
    /*
    816. 模糊坐标
    我们有一些二维坐标，如"(1, 3)"或"(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。
    返回所有可能的原始字符串到一个列表中。

    原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
    此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。

    最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/ambiguous-coordinates
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路：
     * 1、先把字符串的括号去掉，只剩数字部分；
     * 2、枚举坐标中逗号的位置，把字符串分成两部分，这两部分可以分别考虑，且考虑的方法是一样的；
     * 3、对于分好的字符串，
     *     1）如果它自己代表一个整数：此时这个数字在位数大于1的时候，首位不能是0；
     *     2）如果它代表一个小数：枚举小数点的位置，整数部分的规则跟“1)”相同，小数部分的最后一位不能是0
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        int N = s.length() - 2;
        s = s.substring(1, s.length() - 1); // 先把字符串的括号去掉，只剩数字部分
        for (int i = 1; i < N; i++) {
            List<String> part1 = findSpilt(s.substring(0, i));
            if (part1.isEmpty()) {
                continue;
            }
            List<String> part2 = findSpilt(s.substring(i));
            if (part2.isEmpty()) {
                continue;
            }
            for (String s1 : part1) {
                for (String s2 : part2) {
                    res.add("(" + s1 + ", " + s2 + ")"); //注意返回的两个数字中间（逗号之后）都有一个空格。
                }
            }
        }
        return res;
    }

    public static List<String> findSpilt(String s) {
        List<String> list = new ArrayList<>();
        //如果它自己代表一个整数：此时这个数字在位数大于1的时候，首位不能是0
        if (s.length() == 1 || s.charAt(0) != '0') {
            list.add(s);
        }
        //如果它代表一个小数：枚举小数点的位置，整数部分的规则跟“1)”相同，小数部分的最后一位不能是0
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i); //整数部分
            String s2 = s.substring(i); //小数部分
            if ((s1.length() == 1 || s.charAt(0) != '0') && s2.charAt(s2.length() - 1) != '0') {
                list.add(s1 + '.' + s2);
            }
        }
        return list;
    }
}
