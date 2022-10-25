import java.util.*;

public class Lc934_shortestBridge {

    /*
    lc934_最短的桥

    给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。

    岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。

    你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。

    返回必须翻转的 0 的最小数目
     */

    /**
     *  题目中求最少的翻转 0 的数目 等价于 求矩阵中两个岛的最短距离
     *  因此我们可以广度优先搜索来找到矩阵中两个块的最短距离。首先找到其中一座岛，
     *  然后将其不断向外延伸一圈，直到到达了另一座岛，延伸的圈数即为最短距离。
     *  广度优先搜索时，我们可以将已经遍历过的位置标记为 -1，实际计算过程如下:
     *      1、我们通过遍历找到数组 grid 中的 1 后进行广度优先搜索，此时可以得到第一座岛的位置集合，
     *      记为 island，并将其位置全部标记为 -1。
     *      2、随后我们从 island 中的所有位置开始进行广度优先搜索，当它们到达了任意的 1 时，
     *      即表示搜索到了第二个岛，搜索的层数就是答案。
     */
    public static int shortestBridge(int[][] grid) {
        int N = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<>(); //int[] 是因为存储的下标(i,j)
        Queue<int[]> queue = new ArrayDeque<>(); //ArrayDeque是java中对双端队列的线性实现

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    grid[i][j] = -1;
                    //BFS 找第一座岛的位置集合
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            //检查是否有效
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                if (grid[nx][ny] == 1) {
                                    queue.offer(new int[] {nx, ny});
                                    grid[nx][ny] = -1;
                                }
                            }
                        }
                    }
                    //此时island中存放了第一座岛的所有下标集合
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    //BFS
                    while (!queue.isEmpty()) {
                        int size = queue.size(); //此处得用变量记录，否则 queue.size在循环中是会变化的
                        //所有位置都往外扩展一圈
                        for (int k = 0; k < size; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0];
                            int y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                //检查是否有效
                                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[] {nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1){ //能扩展到第二个岛
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println("shortestBridge(grid) = " + shortestBridge(grid));
    }
}
