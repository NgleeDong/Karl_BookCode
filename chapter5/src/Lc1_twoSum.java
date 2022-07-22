import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Lc1_twoSum {
    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);//key是值，value是下标
        for (int i = 1; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[] {i,map.get(val)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] res = twoSum(arr,9);
        System.out.println(Arrays.toString(res));
    }
}
