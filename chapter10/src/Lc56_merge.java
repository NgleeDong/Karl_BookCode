import java.util.*;

public class Lc56_merge {

    /**
     * lc56:合并区间
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        //二位数数组按开始时间进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        int leftRange = intervals[0][0];
        int rightRange = intervals[0][1];
        map.put(leftRange, rightRange);
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (left <= rightRange) {
                //合并
                rightRange = right > rightRange ? right : rightRange;
                //放入map中,若有，则更新
                map.put(leftRange, rightRange);
            } else {
                leftRange = left;
                rightRange = right;
                //放入map中
                map.put(leftRange, rightRange);
            }
        }

        int[][] merge = new int[map.size()][2];
        int index = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            merge[index][0] = entry.getKey();
            merge[index][1] = entry.getValue();
            index++;
        }
        return merge;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        System.out.println("Arrays.deepToString(merge) = " + Arrays.deepToString(merge));
    }
}
