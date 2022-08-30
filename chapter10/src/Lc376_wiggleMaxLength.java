public class Lc376_wiggleMaxLength {

    /**
     * Lc376：摆动序列
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     * 思路：nums 数组的单调数 + 1 就是结果
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        //nums的长度 >= 2

        int monotoneCount = 0; //单调的折线的数量
        int preDiff = 0;
        //preDiff == 1 代表后减前差是正值，即此时是单调增
        //preDiff == -1 代表后减前差是负值，即此时是单调减
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; //相同值不算摆动
            if (nums[i] > nums[i - 1]) {
                if (preDiff == 1) continue; //上一次是正值，这次也是正值，同一个单调性，不统计
                preDiff = 1;
            } else {
                if (preDiff == -1) continue;//上一次是负值，这次也是负值，同一个单调性，不统计
                preDiff = -1;
            }
            //统计单调的折线的数量
            monotoneCount++;
        }

        //单调数 + 1 就是结果
        return ++monotoneCount;
    }
}
