public class Lc1662_arrayStringsAreEqual {

    /*
    1662. 检查两个字符串数组是否相等 【难度：简单】
    给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。

    数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。

    测试用例：
        输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
        输出：true
        解释：
        word1 表示的字符串为 "ab" + "c" -> "abc"
        word2 表示的字符串为 "a" + "bc" -> "abc"
        两个字符串相同，返回 true
     */


    /**
     * 方法一：字符串拼接
     * 这样做是否有一个问题，即这两个数组很长，但第一个字符都不相等，那我其实是做了很多无用功的
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s1 : word1) {
            sb1.append(s1);
        }
        for (String s2 : word2) {
            sb2.append(s2);
        }
        if (sb1.toString().equals(sb2.toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法二：一次遍历+比较
     */
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int x = 0, y = 0;
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(x++) != word2[j].charAt(y++)) {
                return false;
            }
            if (x == word1[i].length()) {
                x = 0;
                i++;
            }
            if (y == word2[j].length()) {
                y = 0;
                j++;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
