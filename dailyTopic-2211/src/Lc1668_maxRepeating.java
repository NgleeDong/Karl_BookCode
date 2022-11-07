public class Lc1668_maxRepeating {

    /*
    1668. 最大重复子字符串
    给你一个字符串sequence，如果字符串 word 【连续重复k次】 形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
    单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。

    给你一个字符串 sequence和 word，请你返回 最大重复值k 。

    测试用例：
    输入：sequence = "ababc", word = "ab"
    输出：2
    解释："abab" 是 "ababc" 的子字符串。
     */

    public static int maxRepeating(String sequence, String word) {
        char[] s1 = sequence.toCharArray();
        char[] s2 = word.toCharArray();
        int res = 0;
        for (int i = 0; i < s1.length; i++) {
            int cur = 0;
            int offset = 0;
            int j = 0;
            while ((i + offset) <= s1.length && j <= s2.length) {
                if (j == s2.length) {
                    j = 0;
                    cur++;
                    res = Math.max(res, cur);
                } else if ((i + offset) < s1.length){
                    if (s1[i + offset] == s2[j]) {
                        offset++;
                        j++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 一个很妙的解法
     * 执行用时：1 ms, 在所有 Java 提交中击败了 59.84% 的用户
     */
    public static int maxRepeating1(String sequence, String word) {
        String s = word;
        int ans = 0;
        while (sequence.contains(s)) {
            ans++;
            s += word;
        }
        return ans;
    }

    //换成StringBuilder
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int maxRepeating2(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int ans = 0;
        while (sequence.contains(sb)) {
            ans++;
            sb.append(word);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("maxRepeating() = " + maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
