import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc78_subsets {

    /**
     * Lc78:子集问题
     */
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    //递归
    public void process(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));//加到结果集中,要放到终止元素的上面，否则会漏掉元素
        //base case
        if (startIndex >= nums.length) {
            return;
        }
        //for循环横向遍历
        for (int i = startIndex; i < nums.length; i++) {
            //处理
            path.addLast(nums[i]);
//            result.add(new ArrayList<>(path));//加到结果集中
            //递归深度遍历
            process(nums, i + 1);
            //回溯
            path.removeLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        process(nums, 0);
        return result;
    }
}
