public class Lc775_isIdealPermutation {

    /*
    775. 全局倒置与局部倒置

     */


    /**
     * 根据题目全局倒置和局部倒置的定义发现，要两者数量相等，
     * 那么对于当前数i,nums[i] > nums[i+1],那么此时nums[i]必须小于等于i+1后面所有数，
     * 否则就会全局倒置的个数就会多于局部倒置。
     * 因此，对于每个位置i来说，若当前位置的数nums[i] 大于后缀最小值，那么直接返回false，
     * 若所有位置都满足，那么代表两者数量相等，返回true。
     *
     */
    public boolean isIdealPermutation(int[] nums) {
        int N = nums.length;
        int minv = nums[N - 1];
        for (int i = N - 3; i >= 0; i--) {
            if (nums[i] > minv) return false;
            //min维护的是i+1位置（不包括）后面所有数的最小值
            minv = Math.min(minv, nums[i + 1]);
        }
        return true;
    }


    /**
     * 超出时间限制
     */
    public boolean isIdealPermutation1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    if (j != i + 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
