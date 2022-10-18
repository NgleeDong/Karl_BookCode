public class Lc902_atMostNGivenDigitSet {

    /*
      lc902. 最大为 N 的数字组合
      给定一个按非递减顺序排列的数字数组digits。你可以用任意次数digits[i]来写的数字。
      例如，如果digits = ['1','3','5']，我们可以写数字，如'13','551', 和'1351315'。
      返回 可以生成的小于或等于给定整数 n 的正整数的个数。
     */


    /**
     * 题解来自官解
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < m; j++) {
                if (digits[j].charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else if (digits[j].charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                } else {
                    break;
                }
            }
            if (i > 1) {
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }
        return dp[k][0] + dp[k][1];
    }
}
