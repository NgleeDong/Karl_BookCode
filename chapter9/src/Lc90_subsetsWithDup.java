import java.util.*;

public class Lc90_subsetsWithDup {

    /**
     * Lc90:子集Ⅱ
     */

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public void process(int[] nums, int startIndex, boolean[] used) {
        result.add(new ArrayList<>(path));//加到结果集中,要放到终止元素的上面，否则会漏掉元素
        //base case，可以不写
        if (startIndex > nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            //判断构造的树的同一层是否使用过，若使用过，直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) { //此处注意！！！！！！！！同一层是false！
                continue;
            }
            //处理
            path.addLast(nums[i]);
            used[i] = true;
            //递归
            process(nums, i + 1, used);

            //回溯
            used[i] = false;
            path.removeLast();
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        process(nums, 0, used);
        return result;
    }
}
