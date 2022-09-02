public class Lc45_jump {

    /**
     * lc45：跳跃游戏Ⅱ
     * @param nums 非负整数数组 nums ，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * @return 使用最少的跳跃次数到达数组的最后一个位置。假设你总是可以到达数组的最后一个位置。
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int count = 0; //记录跳跃的次数
        int curCoverRange = 0; //当前的最大覆盖范围最右的下标
        int nextCoverRange = 0; //下一步的最大覆盖范围最右的下标
        for (int i = 0; i < nums.length; i++) {
            //更新下一步最大覆盖范围
            nextCoverRange = Math.max(i + nums[i], nextCoverRange);
            //若i来到了当前的最大覆盖范围的最远距离
            if (i == curCoverRange) {
                //若此时还没到终点
                if (i != nums.length - 1) {
                    //需要再走一步
                    count++;
                    //更新当前的最大覆盖范围
                    curCoverRange = nextCoverRange;
                    if (nextCoverRange >= nums.length - 1) break;// 下一步的覆盖范围已经可以达到终点，结束循环
                } else { //此时来到了终点
                    break;
                }
            }
        }
        return count;
    }
}
