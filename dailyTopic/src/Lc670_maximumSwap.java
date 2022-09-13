import java.util.Arrays;

public class Lc670_maximumSwap {

    /**
     * lc670. 最大交换
     * @param num 给定一个非负整数，你至多可以交换一次数字中的任意两位。
     * @return 返回你能得到的最大值。
     */
    public static int maximumSwap(int num) {
        //整数转化为数组
        String s = String.valueOf(num);
        int N = s.length();
        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) {
            //numArr[i] = s.charAt(i);
            /*
            2736 ----> Arrays.toString(numArr) = [50, 55, 51, 54]
             */
            numArr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            /*
            2736 ----> Arrays.toString(numArr) = [2, 7, 3, 6]
             */
        }
        System.out.println("Arrays.toString(numArr) = " + Arrays.toString(numArr));

        //处理
        for (int i = 0; i < N - 1; i++) {
            int maxIndex = i;
            //找出右侧比i指向的数值更大的数的下标（且右边那个数是严格大于i指向的）
            for (int j = i + 1; j < N; j++) {
                if (numArr[j] >= numArr[maxIndex] && numArr[i] != numArr[j]) {
                    //注意此处第一个条件 = 也可以，如1993，交换的是第二个9
                    //第二个条件的意思是：i指向的数不能和j指向的数一样，如98368，i指向第一个8，j指向第二个8时是不更新maxIndex的
                    maxIndex = j;
                }
            }
            if (maxIndex != i) { //右侧存在比i指向的数值更大的数的下标
                swap(numArr, i, maxIndex);
                break; // 只能交换一次
            }
        }
        System.out.println("Arrays.toString(numArr) = " + Arrays.toString(numArr));


        //数组转化为int
        int res = 0;
        for (int i = 0; i < numArr.length; i++) {
            res = res*10 + numArr[i];
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int max = maximumSwap(2736);
        System.out.println("max = " + max);
    }
}
