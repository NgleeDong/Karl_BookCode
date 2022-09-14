import java.util.Arrays;

public class Lc1619_trimMean {

    /**
     * lc1619. 删除某些元素后的数组均值
     */
    public static double trimMean(int[] arr) {
        //从小到大排序
        Arrays.sort(arr);
        //确定删除的个数（只统计一边的，当前，左右是相等）
        int deleteCount = (int) (arr.length * 0.05);
        double sum = 0;
        int count = 0;
        //不用真的删除，指针从不被删除的第一个数开始遍历，到不被删除的最后一个数
        for (int i = deleteCount; i < arr.length - deleteCount; i++) {
            sum += arr[i];
            count++;
        }
        return sum / count;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        System.out.println("arr.length = " + arr.length);
        System.out.println("arr.length * 0.05 = " + arr.length * 0.05);
        System.out.println("trimMean(arr) = " + trimMean(arr));
    }
}
