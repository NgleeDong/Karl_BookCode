public class Lc63_uniquePathsWithObstacles {

    /**
     * 63. 不同路径 II
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; //行数
        int n = obstacleGrid[0].length; //列数
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        int[][] dp = new int[m][n];
        //初始化第一行
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                //初始化本来就是0
                break;//堵住了
            }
        }
        //初始化第一列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                //初始化本来就是0
                break;//堵住了
            }
        }
        //计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0}};
        System.out.println("uniquePathsWithObstacles(obstacleGrid) = " + uniquePathsWithObstacles(obstacleGrid));
    }
}
