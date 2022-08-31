public class Lc53_maxSubArray {


    /**
     * Lc53： 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return fun2(nums);
    }

    //方法二：贪心
    //思想：遍历nums，从头开始用count累计，如果count加上num[i]变成了负数，
    // 那么就应该从nums[i+1]重新计算count，count恢复初始值0
    //因为已经变为负数的count只会降低总和！
    public int fun2(int[] nums) {
        int count = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result = result > count ? result : count;
            if (count < 0) { //如果count加上num[i]变成了负数，从nums[i+1]重新计算count，count恢复初始值0
                count = 0;
            }
        }
        return result;
    }



    //方法一：暴力破解（在力扣上会超时！！！）
    public int fun(int[] nums) {
        int count = 0; //用来记录每个元素开头的连续数组的累加和
        int result = Integer.MIN_VALUE; //此处必须是很小的一个值，不能是0
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) { //暴力统计以nums[i]开头的所有数组的和
                count += nums[j];
                result = result > count ? result : count;
            }
        }
        return result;
    }

}
