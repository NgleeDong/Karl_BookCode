import java.util.ArrayList;
import java.util.List;

public class Lc216_combinationSum3 {

    /**
     * LC216：组合总数Ⅲ
     * 在【1，2，3，4，5，6，7，8，9】集合中找到和为 n 的 k 个数的组合，并且每种组合中不存在重复的字数
     */

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void process( int k,int targetSum, int sum, int startNumber) {
        //剪枝
        if (sum > targetSum) {
            return;
        }
        //base case
        if (path.size() == k) {
            if (sum == targetSum) { //满足题目的条件，即和为n
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //剪枝
        for (int i = startNumber; i <= 9 - (k - path.size()) + 1; i++) {
            //处理节点
            sum += i;
            path.add(i);
            //递归
            process(k, targetSum, sum, i + 1);
            //回溯
            sum -= i;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        process(k, n, 0, 1);
        return result;
    }
}
