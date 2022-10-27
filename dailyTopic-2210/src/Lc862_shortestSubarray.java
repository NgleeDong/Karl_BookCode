import java.util.ArrayDeque;
import java.util.Deque;

public class Lc862_shortestSubarray {

    /*
    862. 和至少为 K 的最短子数组

    给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组，并返回该子数组的长度。
    如果不存在这样的 子数组 ，返回 -1 。

    子数组 是数组中 连续 的一部分。

    测试用例：
    输入：nums = [1], k = 1
    输出：1

    输入：nums = [2,-1,2], k = 3
    输出：3
     */

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }


    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        System.out.println("shortestSubarray(nums, 3) = " + shortestSubarray(nums, 3));
    }
}
