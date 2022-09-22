public class Lc96_numTrees {

    /**
     * lc96. 不同的二叉搜索树
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        //填表
        for (int i = 2; i <= n ; i++) {
            //j代表此时哪个数作为顶点
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加一共i个节点
                dp[i] += dp[j - 1] * dp[i - j];
                //j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
            }
        }
        return dp[n];
    }
}
