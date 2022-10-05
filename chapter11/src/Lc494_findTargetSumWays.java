import java.util.Arrays;

public class Lc494_findTargetSumWays {

    /**
     * lc494_目标和
     * https://leetcode.cn/problems/target-sum/
     */


    /**
     * 方法一：暴力递归，可以AC
     */
    public static int findTargetSumWays(int[] nums, int target) {
        return process(nums, 0, target);
    }

    //nums[index...]
    public static int process(int[] nums, int index, int rest) {
        //base case
        if (index == nums.length) {
            return rest == 0 ? 1 : 0;
        }
        //可能性1，给当前值加负号，则rest 是rest + 当前值
        int p1 = process(nums, index + 1, rest + nums[index]);
        //可能性2，给当前值加正号，则rest 是rest - 当前值
        int p2 = process(nums, index + 1, rest - nums[index]);
        return p1 + p2;
    }



    /**
     * 方法二：改dp
     * 可变参数 index、rest
     * index：0~N
     * rest：(target-sum) ~ (target + sum)
     */
    public static int dp(int[] nums, int target) {
        int N = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target)) return 0;//[100] target:-200
        int offset = Math.abs(target - sum); // (target-sum) ~ (target + sum) 整体右移 offset
        int M = offset + target + sum;
        int[][] dp = new int[N + 1][M + 1];
        //初始化，根据base case
        dp[N][0 + offset] = 1;
        //填表
        for (int index = N - 1; index >= 0; index--) {
            //rest 从(target-sum) ~ (target + sum) 映射到 0~M 已经偏移了！不用再偏移了！
            for (int rest = 0; rest <= M; rest++) {
                dp[index][rest] = 0;
               if (rest + nums[index] <= M) {
                   dp[index][rest] += dp[index + 1][rest + nums[index]];
               }
               if (rest - nums[index] >= 0) {
                   dp[index][rest] += dp[index + 1][rest - nums[index]];
               }
            }
        }
        //System.out.println("Arrays.deepToString(dp) = " + Arrays.deepToString(dp));
        return dp[0][target + offset];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        System.out.println("findTargetSumWays(arr, target) = " + findTargetSumWays(arr, target));
        System.out.println("dp(arr, target) = " + dp(arr, target));
    }
}
