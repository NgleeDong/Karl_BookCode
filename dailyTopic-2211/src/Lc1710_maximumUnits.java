import java.util.Arrays;
import java.util.Comparator;

public class Lc1710_maximumUnits {

    /*
    1710. 卡车上的最大单元数
     */

    /**
     * 贪心
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //将二位数组按第二位由大到小进行排序
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        System.out.println("Arrays.deepToString(boxTypes) = " + Arrays.deepToString(boxTypes));
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int count = boxTypes[i][0];//有几个这样的箱子
            if (truckSize >= count) {
                res += count * boxTypes[i][1];
                truckSize -= count;
            } else { //truckSize < count
                res += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            if (truckSize == 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10}, {3,9}, {4,7},{2,5}};
        System.out.println("maximumUnits(boxTypes, 10) = " + maximumUnits(boxTypes, 10));
    }
}
