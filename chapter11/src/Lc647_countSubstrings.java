public class Lc647_countSubstrings {

    /*
    lc647. 回文子串
     */

    /**
     * 暴力循环 + 判断 ，可以Ac
     */
    public static int countSubstrings(String s) {
        int N = s.length();
        int count = 0;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isPalindrome(s.substring(i, j)) == true) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //=============================================================

    /**
     * 方法二：动态规划
     */







}
