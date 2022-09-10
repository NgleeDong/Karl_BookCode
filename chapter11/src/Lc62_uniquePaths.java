public class Lc62_uniquePaths {

    /**
     * 62. 不同路径
     * @param m 网格的行
     * @param n 网格的列
     * @return 机器人从左上角走到网格右下角的不同路径数
     */
    public static int uniquePaths(int m, int n) {
//        if (m == 1 && n == 1) return 0;
//        return process(1,1, m, n);
        return process2(m, n);
    }

    //先试着用一下递归，会超时
    public static int process(int startRow, int startCol, int m, int n) {
        if (startRow > m || startCol > n) return 0;
        if ((startRow == m && startCol == n - 1) || startRow == m - 1 && startCol == n) {
            return 1;
        }
        return process(startRow + 1, startCol, m, n)
                + process(startRow, startCol + 1, m, n);
    }


    //动态规划
    public static int process2(int m, int n) {
        // dp[i][j] 表示从(1, 1)的位置到(i, j)有几条路径
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int uniquePaths = uniquePaths(3, 2);
        System.out.println("uniquePaths = " + uniquePaths);
    }
}
