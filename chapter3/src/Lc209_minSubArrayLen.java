public class Lc209_minSubArrayLen {


    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int subLength = j - i + 1;
                    result = subLength < result ? subLength : result;
                    break;
                }
            }
        }

        return  result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int i = 0; //滑动窗口的起始位置
        int sum = 0; //滑动窗口的数值之和
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                //判断当前结果是否可以更新
                int subLength = j - i + 1;
                result = subLength < result ? subLength : result;
                sum -= nums[i];
                i++; //不断变更i,子数组的起始位置
            }
        }

        return  result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,2,4,9,8,7};
        int target = 12;
        System.out.println(minSubArrayLen(target,nums));
        System.out.println(minSubArrayLen1(target,nums));
    }
}
