import java.util.Arrays;
import java.util.Map;

public class Lc135_candy {

    /**
     * lc135. 分发糖果
     * @param ratings 表示每个孩子的评分。
     * 你需要按照以下要求，给这些孩子分发糖果：
     *     每个孩子至少分配到 1 个糖果。
     *     相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * @return 最少糖果数目
     */
    public static int candy(int[] ratings) {
        int res = 0;
        int[] candyNum = new int[ratings.length];
        for (int i = 0; i < candyNum.length; i++) {
            candyNum[i] = 1;//全初始化为1
        }
//        System.out.println("Arrays.toString(candyNum) = " + Arrays.toString(candyNum));
        //先从先向后遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;//右边的人的糖果数总要比左边的人的多
            }
        }
        //在从后向前遍历
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                candyNum[j] = Math.max(candyNum[j],candyNum[j + 1] + 1);//左边的人的糖果数总要比右边的人的多
            }
        }
//        System.out.println("Arrays.toString(candyNum) = " + Arrays.toString(candyNum));
        //收集最后结果
        for (int i = 0; i < candyNum.length; i++) {
            res += candyNum[i];
        }
        return res;
    }
}
