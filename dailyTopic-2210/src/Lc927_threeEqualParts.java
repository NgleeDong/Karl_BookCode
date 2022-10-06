import java.util.Arrays;

public class Lc927_threeEqualParts {

    /**
     * lc927:三等分
     * https://leetcode.cn/problems/three-equal-parts/
     */
    public static int[] threeEqualParts(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 2; i++) {
            long a = getDecimal(arr, 0, i);
            for (int j = i + 2; j < N; j++) {
                long b = getDecimal(arr, i + 1, j - 1);
                if (a == b) {
                    long c = getDecimal(arr, j, N - 1);
                    if (a == c) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    //二进制转十进制
    public static long getDecimal(int[] arr, int i, int j) {
        long sum = 0;
        int index = 0;
        for (int k = j; k >= i; k--) {
            sum += arr[k] * Math.pow(2, index++);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
//        System.out.println("getDecimal(arr, 0, 2) = " + getDecimal(arr, 0, 2));
        int[] ints = threeEqualParts(arr);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

        int[] test = {0,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,0,0,0,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,0};
                //[0,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,0,0,0,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,0]
        System.out.println("test.length = " + test.length);
        System.out.println("getDecimal(arr, 0, 34) = " + getDecimal(test, 0, 34));
        System.out.println("getDecimal(arr, 35, 66) = " + getDecimal(test, 35, 66));
        System.out.println("getDecimal(arr, 67, N-1) = " + getDecimal(test, 67, test.length - 1));
    }
}
