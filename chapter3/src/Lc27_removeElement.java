public class Lc27_removeElement {

    /**
     * leetcode 27题
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //fastIndex 总是比 slowIndex 快，快当前==val的数值的个数 步
    //快指针和慢指针都是从头开始
    //若快指针指向的数值!=val,快慢指针同时移动一步
    //若快指针指向的数值==val,只有快指针移动一步

    public static int removeElement(int[] nums, int val) {
       int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

}
