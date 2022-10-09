public class Lc1800_maxAscendingSum {

    /**
     * 1800. 最大升序子数组和
     */
    public static int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                curSum += nums[i + 1];
            } else {
                maxSum = Math.max(maxSum, curSum);
                curSum = nums[i + 1];
            }
        }
        maxSum = Math.max(maxSum, curSum);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {12,17,15,13,10,11,12};
        System.out.println("maxAscendingSum(nums) = " + maxAscendingSum(nums));
    }


}
