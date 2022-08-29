

public class Lc37_solveSudoku {

    /**
     *  Lc37. Sudoku Solver 解数独
     */


    /**
     * 解法1
     */
    public boolean process1(char[][] board) {
        for (int i = 0; i < 9; i++) { //遍历行
            for (int j = 0; j < 9; j++) { //遍历列
                if (board[i][j] != '.') {
                    continue;
                }
                //从1-9都试一遍,char-->ASCII码
                for (char c = '1'; c <= '9'; c++) {
                    //判断是否满足数独的约束条件
                    if (!isVaild(i, j, c, board)) {
                        continue;
                    }
                    //处理
                    board[i][j] = c;
                    //递归
                    if (process1(board)) { //如果找到合适一组立刻返回
                        return true;
                    }
                    //回溯
                    board[i][j] = '.';
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 解法2
     */
    boolean flag = false;
    public void process(int row, int col, char[][] board) {
        //使得 row col合法
        if (col == 9) {
            col = 0;
            row++;
        }

        //base case
        if (row == 9) {
            flag = true; //找到答案了
            return;
        }

        //该元素有数字不用填 看下一个位置
        if (board[row][col] != '.') {
            process(row, col + 1, board);
            return;
        }

        //从1-9都试一遍,char-->ASCII码
        for (char c = '1'; c <= '9'; c++) {
            //判断是否满足数独的约束条件
            if (!isVaild(row, col, c, board)) {
                continue;
            }
            //处理
            board[row][col] = c;
            //递归
            process(row, col + 1, board);
            //回溯
            if (flag) return; //找到答案 直接返回 不用回溯了
            board[row][col] = '.';
        }
    }

    public boolean isVaild(int row, int col, char c, char[][] board) {
        //同行是否重复
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        //同列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        // 3x3九宫格是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        //process(0, 0, board); //执行用时：5 ms, 在所有 Java 提交中击败了56.89%的用户
        process1(board);//执行用时：6 ms, 在所有 Java 提交中击败了51.86%的用户
    }
}
