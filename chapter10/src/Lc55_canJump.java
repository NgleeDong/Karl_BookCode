public class Lc55_canJump {

    /**
     * lc55：跳跃游戏
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0; //cover代表可覆盖的范围的右边界
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
