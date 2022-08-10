import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39_combinationSum {
    /**
     * Lc39. 组合总和
     */

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //递归函数
    public void process(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        //base case
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        //&& (sum + candidates[i]) <= target 此处进行了剪枝，前提是排好序！
        for (int i = startIndex; i < candidates.length && (sum + candidates[i]) <= target; i++) {
            int num = candidates[i];
            //处理节点
            sum += num;
            path.add(num);
            //递归
            process(candidates, target, sum, i);
            //回溯
            sum -= num;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        process(candidates, target, 0, 0);
        return result;
    }
}
