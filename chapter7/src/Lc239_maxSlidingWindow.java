import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Lc239_maxSlidingWindow {

    //暴力法：在力扣会超时
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    //左程云解法：维护一个单调的双端队列
    public static int[] maxSlidingWindow01(int[] nums, int k) {
        if (nums == null ||  k < 1 || nums.length < k) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<>(); //放的是下标
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);//把下标放进去
            if (deque.peekFirst() == i - k) { //i-k 是指过期的下标
                deque.pollFirst();
            }
            if (i >= k - 1) { //窗口形成了
                res[index] = nums[deque.peekFirst()];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int l = 3;
        int[] res = maxSlidingWindow(nums, l);
        System.out.println("res = " + Arrays.toString(res));
    }
}
