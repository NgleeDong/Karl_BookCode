public class Lc1620_bestCoordinate {

    /*
    1620. 网络信号最好的坐标
     */

    /**
     * 暴力枚举
     * 由于坐标点的范围是 [0, 50]，因此我们可以直接暴力枚举所有的坐标点 (i, j)
     * 计算每个坐标点的信号强度，然后找出信号强度最大的坐标点。
     *
     * 按照坐标从左到右、从下向上的方式遍历，就完全都不用字典序的问题了。
     */
    public int[] bestCoordinate(int[][] towers, int radius) {
        int max = 0;
        int[] ans = new int[] {0, 0};
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                int cur = 0;
                for (int[] tower : towers) {
                    //计算每个tower到(i,j)的距离
                    double d = Math.sqrt((tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j));
                    if (d <= radius) {
                        //计算信号强度
                        cur += Math.floor(tower[2] / (1 + d));
                    }
                }
                if (cur > max) {
                    //更新此时的结果
                    max = cur;
                    ans = new int[] {i, j};
                }
            }
        }
        return ans;
    }

}
