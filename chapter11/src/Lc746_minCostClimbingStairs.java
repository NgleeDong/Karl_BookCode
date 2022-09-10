public class Lc746_minCostClimbingStairs {

    /**
     * 746. 使用最小花费爬楼梯
     * 2 <= cost.length <= 1000
     */
    public int minCostClimbingStairs(int[] cost) {
//        if (cost == null || cost.length < 1) {
//            return 0;
//        }
//        if (cost.length == 1) {
//            return cost[0];
//        }
        //2 <= cost.length <= 1000
        if (cost.length == 2) {
            //走一步就可以：可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
