public class Lc915_partitionDisjoint {
    /*
    915. 分割数组

    给定一个数组nums，将其划分为两个【连续子数组】left和right，使得：

    left中的每个元素都小于或等于right中的每个元素。
    left 和 right 都是非空的。
    left 的长度要尽可能小。

    在完成这样的分组后返回left的长度。
     */

    public static int partitionDisjoint(int[] nums) {
        int leftRangeMax = nums[0];
        int leftRange = 1;
        int curMax = leftRangeMax; //遍历到某个位置时，从开始到这个位置的最大值是什么？
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < leftRangeMax) {
                leftRange = i + 1;
                leftRangeMax = curMax;
            } else { //nums[i] >= leftRangeMax
                curMax = nums[i] > curMax ? nums[i] : curMax;
            }
        }
        return leftRange;
    }
}
