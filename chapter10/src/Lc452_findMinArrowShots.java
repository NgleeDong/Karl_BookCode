import java.util.Arrays;
import java.util.Comparator;

public class Lc452_findMinArrowShots {

    /**
     * lc452. 用最少数量的箭引爆气球
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        //将二维数组points按第二维进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });
        System.out.println("Arrays.deepToString(points) = " + Arrays.deepToString(points));

        int count = 0; //需要消耗弓箭数
        int rightRange = points[0][1];
        count++;
        for (int i = 1; i < points.length; i++) {
            int left = points[i][0];
            System.out.println("left = " + left);
            System.out.println("rightRange = " + rightRange);
            if (left <= rightRange) {
                continue;
            } else { //当前的左边界>rightRange
                //更新rightRange
                rightRange = points[i][1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println("minArrowShots = " + minArrowShots);
    }
}
