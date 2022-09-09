public class Lc70_climbStairs {

    /**
     * lc70:爬楼梯
     */
    public static int climbStairs(int n) {
        return process3(n);
    }

    /*
    爬到第一级楼梯：1种方法
    爬到第二级楼梯：2种方法
    爬到第三级楼梯：第一级爬两阶（一种）+从第二级爬一阶（两种） = 3种方法
    爬到第四级楼梯：第二级爬两阶（2种）+从第3级爬一阶（3种） = 5种方法
    ...
    --->  Fn = Fn-1 + Fn-2
     */

    //方法一：递归（在lc中会超时）
    //画出递归树可知：时间复杂度O(2^n) 空间复杂度O(n)，出现了大量的重复计算
    public static int process(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return process(n - 1) + process(n - 2);
    }

    //方法二：记忆化搜索（自顶向下的动态规划）
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户 时间复杂度：O(n) 空间：O(n)
    public static int process2(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //方法三：dp的优化(滚动数组)
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户 时间复杂度：O(n) 空间：O(1)
    public static int process3(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println("i = " + i);
    }
}
