import java.util.Arrays;

public class Lc698_canPartitionKSubsets {

    /**
     * lc698. 划分为k个相等的子集
     */
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //求总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //若不能平均分配，返回false
        if (sum % k != 0) return false;
        //可以平均分配
        int target = sum / k;
        //k个桶
        int[] bucket = new int[k];
        //排序：降序排列，增加剪枝的命中率
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return process(nums, k, 0, target, bucket);
    }

    public static boolean process(int[] nums, int k, int index, int target, int[] bucket) {
        //base case
        if (index == nums.length) {
            return true;
        }
        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) { //i代表桶的下标
            //把第一个球放到 不是 第一个桶中了，直接break
            //因为对于第一个球，任意放到某个桶中的效果都是一样的，所以我们规定放到第一个桶中
            if (i > 0 && index == 0) break ;
            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            //剪枝,放入球后超过 target 的值，选择一下桶
            if (nums[index] + bucket[i] > target) {
                continue;
            }
            //处理:放入i号桶
            bucket[i] += nums[index];
            //递归,处理下一个球，即 nums[index + 1]
            if (process(nums, k, index + 1, target, bucket)) return true;
            //回溯
            bucket[i] -= nums[index];
        }
        //某个球选这个 k 个桶都不满足要求
        return false;
    }



    public static void main(String[] args) {
        int n = 3;
        int a = 1 << n; //代表2的n次幂
        System.out.println("a = " + a);

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println("canPartitionKSubsets(nums, k) = " + canPartitionKSubsets(nums, k));
    }
}
