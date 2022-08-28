import java.util.*;

public class Lc491_findSubsequences {

    /**
     * 491. 递增子序列
     */

    static List<List<Integer>> result = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();

    public static void process(int[] nums, int startIndex) {
        //base case
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
            //此处不能return，要取树上的所有节点
        }

        HashSet<Integer> set = new HashSet<>(); //记录本层的元素
        //for循环横向遍历
        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) { //同一层不能取一样的
                if (path.size() == 0 || (path.size() > 0 && num >= path.peekLast())) { //处理刚开始的情况，并保证是递增的
                    //处理
                    set.add(num);
                    path.addLast(num);
                    //递归纵向遍历
                    process(nums, i + 1);
                    //回溯
                    path.removeLast();
                }
            }
        }

    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        process(nums, 0);
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,6};
        List<List<Integer>> lists = findSubsequences(nums);
    }
}
