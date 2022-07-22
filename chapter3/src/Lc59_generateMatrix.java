public class Lc59_generateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startx = 0, starty = 0;
        int count = 1; //计数，往数组里填充
        int offset = 1; //控制好左闭右开的偏移变量
        int loop = n/2; //画圈的次数

        while (loop > 0) {
            int i = startx;
            int j = starty;

            for (; j <  n - offset; j++) {
                result[i][j] = count++;
            }

            for (; i < n - offset; i++) {
                result[i][j] = count++;
            }

            for (; j > starty; j--) {
                result[i][j] = count++;
            }

            for (; i > startx; i--) {
                result[i][j] = count++;
            }

            //下一圈开始时
            startx++;
            starty++;
            offset++;
            loop--;
        }

        //若n为奇数
        if (n%2 == 1) {
            result[startx][starty] = count;//填充中间
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] m = generateMatrix(4);
        for (int[] i : m) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println("");
        }
    }
}
