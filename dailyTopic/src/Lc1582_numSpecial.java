import java.util.Arrays;

public class Lc1582_numSpecial {

    /**
     * 1582. 二进制矩阵中的特殊位置
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        int rows = mat.length; //行数
        int cols = mat[0].length;//列数
        int count = 0;
        int[] rowCount = new int[rows];//每一行的1的个数
        int[] colCount = new int[cols];//每一列的1的个数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i] += 1;
                    colCount[j] += 1;
                }
            }
        }
        // System.out.println(Arrays.toString(rowCount));
        // System.out.println(Arrays.toString(colCount));
        for (int i = 0; i < rows; i++) {
            if (rowCount[i] == 1) { //第i行只出现了一个1
                for (int j = 0; j < cols; j++) {
                    if (colCount[j] == 1) { //此时第j列也只出现了一个1
                        if (mat[i][j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
