import java.util.Arrays;

public class Interview01_08_setZeroes {
    /**
     * 面试题 01.08. 零矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * https://leetcode.cn/problems/zero-matrix-lcci/
     */

    public static void setZeroes(int[][] matrix) {
        int M = matrix.length; //行
        int N = matrix[0].length; //列
        int[][] isIgnore = new int[M][N];//其值为1，代表某个值可以忽略，为0代表不能忽略
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isIgnore[i][j] == 0 && matrix[i][j] == 0) { //没有设置过
                    //则将其所在的行与列清零。
                    for (int k = 0; k < M; k++) {
                        if (matrix[k][j] != 0) { //某个数原本就是0的话，不能忽略它
                            isIgnore[k][j] = 1;
                        }
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < N; k++) {
                        if (matrix[i][k] != 0) { //某个数原本就是0的话，不能忽略它
                            isIgnore[i][k] = 1;
                        }
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }

    public static void setZeroes2(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[] rowArr = new boolean[M];
        boolean[] colArr = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rowArr[i] = colArr[j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rowArr[i] || colArr[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     * ---> lc73. 矩阵置零
     */


    public static void main(String[] args) {
        int[][] m = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Arrays.deepToString(m) = " + Arrays.deepToString(m));
        setZeroes(m);
        System.out.println("Arrays.deepToString(m) = " + Arrays.deepToString(m));
    }

}
