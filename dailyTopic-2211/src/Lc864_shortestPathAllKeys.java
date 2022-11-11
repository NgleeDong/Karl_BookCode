import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Lc864_shortestPathAllKeys {

    /*
    864. 获取所有钥匙的最短路径
     */
    static int N = 35, K = 10, INF = 0x3f3f3f3f;
    static int[][][] dist = new int[N][N][1 << K];
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys1(String[] g) {
        int n = g.length, m = g[0].length(), cnt = 0;
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], INF);
                char c = g[i].charAt(j);
                if (c == '@') {
                    d.addLast(new int[]{i, j, 0});
                    dist[i][j][0] = 0;
                } else if (c >= 'a' && c <= 'z') cnt++;
            }
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                char c = g[nx].charAt(ny);
                if (c == '#') continue;
                if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                int ncur = cur;
                if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                if (ncur == (1 << cnt) - 1) return step + 1;
                if (step + 1 >= dist[nx][ny][ncur]) continue;
                dist[nx][ny][ncur] = step + 1;
                d.addLast(new int[]{nx, ny, ncur});
            }
        }
        return -1;
    }

    //==========================================================================
    //下方是自己写的 有错误 ac不了

    public static int shortestPathAllKeys(String[] grid) {
        int keysNum = 0;
        int N = grid.length;
        int M = grid[0].length();
        char[][] chars = new char[N][M];
        int[] cur = new int[2];
        for (int i = 0; i < N; i++) {
            String s = grid[i];
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') { //代表钥匙
                    keysNum++;
                }
                if (c == '@') {
                    cur[0] = i;
                    cur[1] = j;
                }
                chars[i][j] = c;
            }
        }
        System.out.println("keysNum = " + keysNum);
        return process(chars,new int[N][M], cur, new HashSet<Character>(), keysNum, 0);
    }

    static int[] direction = {0, -1, 0, 1, 0}; //控制方向的数组

    public static int process(char[][] grid, int[][] used, int[] cur, HashSet<Character> keysSet, int keysNum, int steps) {
        int x = cur[0];
        int y = cur[1];
        if (grid[x][y] == '#') { //当前是一堵墙
            return -1;
        }
        //当前来到的是锁，并且我没有这个锁的钥匙
        if ((grid[x][y] >= 'A' && grid[x][y] <= 'Z') && !keysSet.contains((char)(grid[x][y] + 32))) {
            return -1;
        }
        //当前来到的是空房间，或者钥匙,标记来到过
        used[x][y]++;
        //如果是钥匙，拿起来
        if (grid[x][y] >= 'a' && grid[x][y] <= 'z') { //拿起钥匙
            keysSet.add(grid[x][y]);
            if (keysNum == keysSet.size()) {
                return steps;
            }
        }
        //继续走
        int p = -1;
        for (int k = 0; k < 4; k++) {
            int x1 = x + direction[k];
            int y1 = y + direction[k + 1];
            if (isVaild(x1, y1, grid.length, grid[0].length) && used[x1][y1] <= 2) {
                int temp = process(grid, used, new int[] {x1, y1}, keysSet, keysNum, steps + 1);
                if (temp == -1) { //没拿到所有钥匙并且堵住了
                    continue;
                } else {
                    p = (p == -1) ? temp : Math.min(p, temp);
                }
            }
        }
        return p;
    }

    public static boolean isVaild(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) {
        String[] grid = {"@.a.#","###.#","b.A.B"};
        System.out.println("shortestPathAllKeys(grid) = " + shortestPathAllKeys(grid));

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        System.out.println("set.contains((char)('A' + 32)) = " + set.contains((char) ('A' + 32)));
    }
}
