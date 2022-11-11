public class Lc764_orderOfLargestPlusSign {

    /*
    764. 最大加号标志
     */

    /**
     * 初始化四个数组，分别存储从(i, j) 开始向四个方向扩展能到的最长长度是多少（包含自己）。
     * 二重循环遍历每个点作为中心点，求left[i][j], right[i][j], up[i][j], down[i][j]四个值中的最小值，来更新答案。
     *
     * 作者：chouring
     * 链接：https://leetcode.cn/problems/largest-plus-sign/solution/er-zhong-xun-huan-bao-li-mei-ju-ji-ke-by-otvp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] g = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];

        //初始化grid矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            g[mine[0]][mine[1]] = 0;
        }
        //从(i, j) 开始向四个方向扩展能到的最长长度是多少（包含自己）
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //左
                int temp = g[i][j] == 1 ? 1 : 0;
                int k = temp;
                while ((j - k >= 0) && g[i][j - k] == 1) {
                    k++;
                }
                left[i][j] = k;
                //右
                k = temp;
                while ((j + k < n) && g[i][j + k] == 1) {
                    k++;
                }
                right[i][j] = k;
                //上
                k = temp;
                while ((i - k >= 0) && g[i - k][j] == 1) {
                    k++;
                }
                up[i][j] = k;
                //下
                k = temp;
                while ((i + k < n) && g[i + k][j] == 1) {
                    k++;
                }
                down[i][j] = k;
            }
        }
        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < n; j++) {
        //        System.out.println("left = " + left[i][j]);
        //        System.out.println("right = " + right[i][j]);
        //        System.out.println("up = " + up[i][j]);
        //        System.out.println("down = " + down[i][j]);
        //    }
        //}
        //遍历每个点作为中心点，求left[i][j], right[i][j], up[i][j], down[i][j]四个值中的最小值
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,
                        Math.min(
                                Math.min(left[i][j], right[i][j]),
                                Math.min(up[i][j], down[i][j])));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        int orderOfLargestPlusSign = orderOfLargestPlusSign(n, mines);
        System.out.println("orderOfLargestPlusSign = " + orderOfLargestPlusSign);
    }
}
