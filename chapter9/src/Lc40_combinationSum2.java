import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc40_combinationSum2 {

    /**
     * Lc40:组合总数Ⅱ
     * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     *
     * candidates中的每个数字在每个组合中只能使用一次。
     *
     * 注意：解集不能包含重复的组合。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //递归
    public void process(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        //(sum + candidates[i] <= target)为剪枝操作
        for (int i = startIndex; i < candidates.length && (sum + candidates[i] <= target); i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            //处理节点
            int num = candidates[i];
            sum += num;
            path.add(num);
            //递归
            process(candidates, target, sum, i + 1, used);
            //回溯
            sum -= num;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);//排序
        process(candidates,target,0,0, used);
        return result;
    }
}
