public class Lc509_fib {

    /**
     * 斐波那契数列
     */
    //方法一：暴力递归 执行用时：8 ms在所有 Java 提交中击败了22.90%的用户 时间复杂度：O(2^n) 空间：O(n)
    public int fib1(int n) {
        if (n < 2) return n;
        return fib1(n - 1) + fib1(n - 2);
    }
    //方法二：动态规划 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户 时间复杂度：O(n) 空间：O(n)
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //方法三：优化后的dp 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户 时间复杂度：O(n) 空间：O(1)
    public int fib2(int n) {
        if (n < 2) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }

}
