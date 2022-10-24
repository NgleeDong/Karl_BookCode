public class Lc1768_mergeAlternately {

    /*
    1768. 交替合并字符串
     */

    /**
     * 思路：双指针，一个指针指向word1，一个指针指向word2
     * 直接按照题目的要求模拟即可
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 != word1.length() && index2 != word2.length()) {
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }
        while (index1 != word1.length()) {
            sb.append(word1.charAt(index1++));
        }
        while (index2 != word2.length()) {
            sb.append(word2.charAt(index2++));
        }
        return sb.toString();
    }

    /**
     * 或者这样写 都一样的 看起来更精简一些
     */
    public String mergeAlternately1(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i != word1.length() || j != word2.length()) {
            if (i != word1.length()) {
                sb.append(word1.charAt(i++));
            }
            if (j != word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}
