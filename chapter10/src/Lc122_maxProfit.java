public class Lc122_maxProfit {

    /**
     * 122. 买卖股票的最佳时机 II
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * @param prices 整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * @return 能获得的 最大 利润 。
     */

    //思路：把总利润进行拆分！！只要第二天的利润是正的，就可以收集起来
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
//            int profit = prices[i + 1] - prices[i];
//            if (profit > 0) result += profit;
            result += Math.max(prices[i + 1] - prices[i], 0);
        }
        return result;
    }
}
