import java.util.Arrays;
import java.util.Comparator;

public class Lc646_findLongestChain {

    /**
     * Lc646. 最长数对链
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        //对二维数组进行排序:按照第二个数进行升序排列
        //类似活动选择问题，每次选择结束时间最早的活动进行贪心选择策略
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //若第二个数相同，按第一个数进行升序排序
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        System.out.println("Arrays.deepToString(pairs) = " + Arrays.deepToString(pairs));

        int rightRange = Integer.MIN_VALUE;
        int longestChain = 0;
        //从左到右遍历二位数组
        for (int i = 0; i < pairs.length; i++) {
            int[] arr = pairs[i];
            int left = arr[0];
            if (left > rightRange) {
                longestChain++;
                rightRange = arr[1]; //更新rightRange
            }
        }
        return longestChain;
    }

    public static void main(String[] args) {
        int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        int longestChain = findLongestChain(pairs);
        System.out.println("longestChain = " + longestChain);
    }
}
