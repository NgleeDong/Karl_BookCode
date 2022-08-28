import java.util.*;

public class Lc46_permute {

    /**
     * Lc46:全排列
     */

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    HashSet<Integer> set = new HashSet<>(); //题目不含重复数字，所以用它判断深度遍历时重复元素

    public void process(int[] nums) {
        //base case 因为是全排列，必须相等
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //for循环横向遍历
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                //处理
                set.add(num);
                path.addLast(num);
                //递归
                process(nums);
                //回溯
                set.remove(num);
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        process(nums);
        return result;
    }
}
