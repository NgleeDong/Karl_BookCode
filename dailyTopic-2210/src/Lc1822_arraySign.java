public class Lc1822_arraySign {

    /*
    1822. 数组元素积的符号
    已知函数signFunc(x) 将会根据 x 的正负返回特定值：

    如果 x 是正数，返回 1 。
    如果 x 是负数，返回 -1 。
    如果 x 是等于 0 ，返回 0 。
    给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。

    返回 signFunc(product) 。

    测试用例：
    输入：nums = [-1,-2,-3,-4,3,2,1]
    输出：1
    解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1

     */

    /**
     * 思路：不能把乘积都算出来，然后根据正负判断，因为这样会越界，结果不正确
     * 我们只需遍历一遍数组，统计数组中负数的个数即可
     * 当碰到0，返回值肯定是0
     * 若遍历完，负数的个数有偶数个，说明结果是正值，返回 1
     * 若负数的个数有奇数个，说明结果是负值，返回 -1
     */
    public int arraySign(int[] nums) {
        int lessZeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                lessZeroCount++;
            }
        }
        if ((lessZeroCount & 1) == 0) { //说明有偶数个 < 0 的，结果 > 0
            return 1;
        } else { //结果 < 0
            return -1;
        }
    }
}
