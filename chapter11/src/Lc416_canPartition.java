public class Lc416_canPartition {

    /**
     * lc416：分割等和子集
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        return process(nums, 0, target);
    }

    //当前考虑到了index号货物，index....所有货物可以自由选择
    //做的选择不能超过 sum / 2
    public boolean process(int[] nums, int index, int rest) {
        //base case
        if (rest == 0) {
            return true;
        }
        if (rest < 0 || index == nums.length) {
            return false;
        }
        //不选择当前的这个数
        boolean b1 = process(nums, index + 1, rest);
        //选择当前这个数
        boolean b2 = process(nums, index + 1, rest - nums[index]);
        return b1 || b2;
    }

    /**
     * 方法二：dp 根据 0-1背包小改动一下
     */
    public boolean dp(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        int N = nums.length;
        //可变参数的变化范围：
        //index: 0 ~ N
        //rest: 0 ~ target
        int[][] dp = new int[N + 1][target + 1];
        //填dp表
        //初始化 dp[N][....] = 0 --->不用填
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                //不要当前的货
                int p1 = dp[index + 1][rest];
                //要当前的货
                int p2 = 0;
                int next = rest - nums[index] < 0 ? -1 : dp[index + 1][rest - nums[index]];
                if (next != -1) { //代表“要当前的货”是有效的
                    p2 = nums[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][target] == target;
    }
}
