public class Lc73_setZeroes {

    /**
     * lc73. 矩阵置零
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     */

    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        //不使用额外空间，使用第一行的值，和第一列的值来标记这一行或这一列是否需要清零
        //但需要先记住 第一行 或 第一列是否需要清零
        boolean firstRow = false;
        boolean firstCol = false;
        //检查第一行是否需要清零
        for (int i = 0; i < N; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }
        //检查第一列是否需要清零
        for (int j = 0; j < M; j++) {
            if (matrix[j][0] == 0) {
                firstCol = true;
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) { //需要标记
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { //已经被标记了
                    /*
                    此处有一个细节，就是当第一行某个位置为 0 的时候，我们需要把这一行设置为0，这一列也需要设置为0
                    但我们只记录了第一行需要设置，而没有记录这一列
                    不用记录！因为判断条件是 是否 == 0， 我们标记也是标记为 0
                    若是 0 的话，这一列在此处满足条件，也会被设置为0 ！ 很巧妙！
                     */
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for (int i = 0; i < N; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
