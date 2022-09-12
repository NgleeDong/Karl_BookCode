public class Lc1608_specialArray {

    /**
     * 1608. 特殊数组的特征值
     */

    public int specialArray(int[] nums) {
        //如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值
        //知 0<= x <= nums.length
        for (int x = 0; x <= nums.length; x++) {
            int count = 0; //统计>=x的个数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        return -1;

    }

}
