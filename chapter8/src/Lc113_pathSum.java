import java.util.ArrayList;
import java.util.List;

public class Lc113_pathSum {

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
     * @param root 二叉树的根节点
     * @param targetSum 整数目标和
     * @return 路径总和等于给定目标和的路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(list));
        }
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        list.remove(list.size() - 1);//回溯用
        return res;
    }
}
