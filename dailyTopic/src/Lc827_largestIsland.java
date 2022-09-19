import java.util.*;

public class Lc827_largestIsland {

    /**
     * lc827. 最大人工岛
     */
    static int[] direction = {0, -1, 0, 1, 0}; //控制方向的数组

    public static int largestIsland(int[][] grid) {
        //遍历整个二维数组，并将每个岛屿进行标记
        int N = grid.length;
        int res = 0; //记录当前岛屿的最大面积
        int[][] tag = new int[N][N];
        int land = 1;
        Map<Integer, Integer> areaMap = new HashMap<>();//key为岛屿编号，val为岛屿的面积
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    //用dfs进行深度搜索，在dfs过程中标记，得到和它相连的岛屿的总面积
                    areaMap.put(land, dfs(grid, tag, i, j, land));
                    //更新当前最大的岛屿面积
                    res = Math.max(res, areaMap.get(land));
                    //land编号++
                    land++;
                }
            }
        }
        System.out.println("Arrays.deepToString(tag) = " + Arrays.deepToString(tag));
        //遍历整个二维数组，将 0 -> 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    Set<Integer> connected = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x1 = i + direction[k];
                        int y1 = j + direction[k + 1];
                        if (!isVaild(x1, y1, N) || tag[x1][y1] == 0 || connected.contains(tag[x1][y1])) {
                            //越界 || tag[x1][y1] == 0代表某个方向没有可以相连的岛屿 ||
                            // connected.contains(tag[x1][y1]) 代表 已经计算过与之相连的面积了
                            continue;
                        }
                        z += areaMap.get(tag[x1][y1]);
                        connected.add(tag[x1][y1]);
                    }
                    res = Math.max(res, z);
                }
            }
        }

        return res;
    }

    public static int dfs(int[][] grid, int[][] tag, int x, int y, int land) {
        int N = grid.length;
        int res = 1;
        tag[x][y] = land;//把它标记为某个岛屿
        //遍历它的上下左右，若有连接，则继续dfs
        for (int i = 0; i < 4; i++) {
            int x1 = x + direction[i];
            int y1 = y + direction[i + 1];
            if (isVaild(x1, y1, N) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
                res += dfs(grid, tag, x1, y1, land);
            }
        }
        //遍历完 return 这个岛屿最后的总面积
        return res;
    }

    /**
     * 判断下标是否有效
     */
    public static boolean isVaild(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        int largestIsland = largestIsland(grid);
        System.out.println("largestIsland = " + largestIsland);
    }
}
