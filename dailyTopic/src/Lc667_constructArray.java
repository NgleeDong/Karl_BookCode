import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lc667_constructArray {

    /**
     * 667. 优美的排列 II
     */
    public static int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int temp1 = 1;
        int temp2 = k + 1;
        for (int i = 0; i <= k; i+=2) { //偶数下标，填充1，2，3，...
            answer[i] = temp1++;
        }
        for (int i = 1; i <= k; i+=2) { //奇数下标，填充k+1，k，k-1
            answer[i] = temp2--;
        }
        //下标 0~k 的前k+1个数，用到的肯定是1~k+1，后面的数从k+2开始
        for (int i = k + 2; i < n; i++) { //从 k+1~n-1 顺序填充即可
            answer[i] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ints = constructArray(3, 2);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}
