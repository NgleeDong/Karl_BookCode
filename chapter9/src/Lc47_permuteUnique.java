import java.util.*;

public class Lc47_permuteUnique {


    /**
     * Lc47:给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     */

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public void process(int[] nums, boolean[] used) {
        //base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>(); //用来控制横向遍历不可以重复
        //for循环横向遍历
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == false) {
                //处理
                set.add(num);
                used[i] = true;
                path.addLast(num);
                //递归纵向遍历,纵向遍历
                process(nums, used);
                //回溯
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//排序
        boolean[] used = new boolean[nums.length]; //初始化一个boolean数组，用来记录是否拿过
        process(nums, used);
        return result;
    }
}
