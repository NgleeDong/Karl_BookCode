import java.util.Arrays;
import java.util.HashSet;

public class Lc1704_halvesAreAlike {

    /*
    1704. 判断字符串的两半是否相似

    给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
    两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
    注意，s 可能同时含有大写和小写字母。

    如果 a 和 b 相似，返回 true ；否则，返回 false 。

    输入：s = "book"
    输出：true
    解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/determine-if-string-halves-are-alike
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean halvesAreAlike(String s) {
        Character[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(chars));
        char[] arr = s.toCharArray();
        int mid = arr.length / 2;
        int leftCount = 0;
        int rightCount = 0;
        int index = 0;
        while (index != arr.length) {
            if (set.contains(arr[index])) {
                if (index < mid) {
                    leftCount++;
                } else {
                    rightCount++;
                }
            }
            index++;
        }
        return leftCount == rightCount;
    }
}
