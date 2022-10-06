public class Lc516_longestPalindromeSubseq {

    /**
     * lc516.最长回文子序列
     * https://leetcode.cn/problems/longest-palindromic-subsequence/
     */


    /**
     * 递归  会超时
     */
    public static int longestPalindromeSubseq(String s) {
        return process(s.toCharArray(), 0, s.length() - 1);
    }

    //范围尝试模型
    //返回 arr[L...R]上的最长回文子序列
    public static int process(char[] arr, int L, int R) {
        if (L == R) return 1;
        if (L == R - 1) {
            return arr[L] == arr[R] ? 2 : 1;
        }
        int p1 = process(arr, L + 1, R - 1);
        int p2 = process(arr, L, R - 1);
        int p3 = process(arr, L + 1, R);
        int p4 = arr[L] == arr[R] ? (2 + process(arr, L + 1, R - 1)) : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    //===================================================================================

    /**
     * 改dp
     */
    public static int dp(String s) {
        char[] arr = s.toCharArray();
        int N = s.length();
        int[][] dp = new int[N][N];
        //初始化
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 2 : 1;
        }
        //填表
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                int p1 = dp[L + 1][R - 1];
                int p2 = dp[L][R - 1];
                int p3 = dp[L + 1][R];
                int p4 = arr[L] == arr[R] ? (2 + dp[L + 1][R - 1]) : 0;
                dp[L][R] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
            }
        }
        return dp[0][N - 1];
    }
    //====================================================================================

    /**
     * 优化dp
     */
    public static int dp2(String s) {
        char[] arr = s.toCharArray();
        int N = s.length();
        int[][] dp = new int[N][N];
        //初始化
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 2 : 1;
        }
        //填表
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
                if (arr[L] == arr[R]) { //有可能有可能性4
                    dp[L][R] = Math.max(dp[L][R], dp[L + 1][R - 1] + 2);
                }
            }
        }
        return dp[0][N - 1];
    }
}
