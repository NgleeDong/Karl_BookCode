import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15_threeSum {

    /**
     * 你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
     * 请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     */

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum1(nums, 0);
    }


    /**
     * 【三和问题】：无序数组，一个数k，找出所有和为 k 的三元组？（注意：答案中不可以包含重复的三元组。）
     * 对数组进行排序
     * 准备一个 p指针，从左往右走
     * 假设把[p]作为三元组的第一个数，那么问题就变成了 p指针后面找累加和为 k - [p] 的二元组
     * 那么 在这些二元组中 每一个二元组都添加一个 [p]，则都是满足条件的三元组
     * 注意：当p来到某个位置的时候，若发现这个数和其前面的数一样，直接跳过
     */
    public static List<List<Integer>> threeSum1(int[] nums, int k) {
        Arrays.sort(nums);
        int p = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (p < nums.length) {
            if (nums[p] > k) { //剪枝
                break;
            }
            //当p来到某个位置的时候，若发现这个数和其前面的数一样，直接跳过
            if (p == 0 || nums[p - 1] != nums[p]){
                List<List<Integer>> lists = twoSum1(nums, p + 1, k - nums[p]);
                for (List<Integer> list : lists) {
                    list.add(nums[p]);
                    res.add(list);
                }
            }
            p++;
        }
        return res;
    }

    /**
     * 先想一下两个和的问题怎么做？
     * 【两和问题】：无序数组，一个数k，找出所有和为k的二元组？（注意：答案中不可以包含重复的三元组。）
     * 先对无须数组进行排序
     * 双指针 L从左往右 R从右往左
     * [L] + [R] 和 k 是什么关系？
     * ① [L] + [R] < k, L++
     * ① [L] + [R] > k, R--
     * ① [L] + [R] == k, 收集答案，然后让 L++
     * 收集答案的时候要注意：要保证L位置的数和其左边的数字（如果有）是否一样，不一样才能收集
     * 因为如果一样，此时的答案已经是收集过的！
     * L == R的时候停止循环
     */
    public static List<List<Integer>> twoSum1(int[] nums, int begin, int k) {
        Arrays.sort(nums);
        int L = begin;
        int R = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] < k) {
                L++;
            } else if (nums[L] + nums[R] > k) {
                R--;
            } else { //[L] + [R] == k, 收集答案，然后让 L++
                if (L == begin || nums[L - 1] != nums[L]) { //要保证L位置的数和其左边的数字（如果有）是否一样，不一样才能收集
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    res.add(cur);
                }
                L++;
            }
        }
        return res;
    }
}
