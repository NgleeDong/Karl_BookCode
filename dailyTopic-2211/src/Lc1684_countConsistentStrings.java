public class Lc1684_countConsistentStrings {

    /*
    1684. 统计一致字符串的数目 ---- 难度【简单】

    给你一个由不同字符组成的字符串 allowed和一个字符串数组words。
    如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。

    请你返回words数组中一致字符串 的数目。

    输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
    输出：2
    解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        boolean[] arr = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            arr[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            int index = 0;
            while (index != word.length()) {
                if (arr[word.charAt(index) - 'a'] == false) {
                    break;
                }
                index++;
            }
            if (index == word.length()) {
                res++;
            }
        }
        return res;
    }
}
