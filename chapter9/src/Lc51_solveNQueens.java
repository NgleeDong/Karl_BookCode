import java.util.*;

public class Lc51_solveNQueens {

    /**
     * Lc51：N皇后问题
     */

    List<List<String>> result = new ArrayList<>();

    /**
     * 递归函数
     * @param n n个皇后，nxn的棋盘
     * @param row 当前来到的行
     * @param chessboard 棋盘
     */
    public void process(int n, int row, char[][] chessboard) {
        //base case
        if (row == n) {
            List<String> path = new ArrayList<>();
            for (char[] chars : chessboard) {
                path.add(String.copyValueOf(chars));
            }
            result.add(path);
            return;
        }
        //for循环横向遍历:控制列
        for (int col = 0; col < n; col++) {
            //不满足约束条件
            if (!isVaild(n, row, col, chessboard)) {
                continue;
            }
            //处理
            chessboard[row][col] = 'Q';
            //递归，控制行
            process(n, row + 1, chessboard);
            //回溯
            chessboard[row][col] = '.';
        }
    }

    /**
     * 是否满足N皇后的条件
     * @param n n
     * @param row 当前行
     * @param col 当前列
     * @param chessboard 棋盘
     * @return 是否满足
     */
    public boolean isVaild(int n, int row, int col, char[][] chessboard) {
        //检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--,j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        //没有冲突
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        //棋盘
        char[][] chessboard = new char[n][n];
        //往棋盘中填充'.'
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        //进入递归函数处理逻辑
        process(n, 0, chessboard);
        return result;
    }
}
