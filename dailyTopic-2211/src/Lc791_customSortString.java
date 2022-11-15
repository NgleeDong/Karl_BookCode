import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lc791_customSortString {

    /*
    791. 自定义字符串排序  难度：mid

    给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。

    对 s 的字符进行置换，使其与排序的order相匹配。更具体地说，如果在order中的字符 x 出现字符 y 之前，
    那么在排列后的字符串中， x也应该出现在 y 之前。

    返回 满足这个性质的 s 的任意排列。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/custom-sort-string
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了45.82%的用户
     */
    public String customSortString(String order, String s) {
        //准备一个词频表，统计s中每个字母出现的词频
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        //存放结果
        StringBuilder sb = new StringBuilder();
        //遍历order串，看是否在map中出现过
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
            }
            map.remove(c);
        }
        //再把map中剩余的拼上
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int k = 0; k < count; k++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
