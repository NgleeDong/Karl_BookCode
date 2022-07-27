public class Lc112_hasPathSum {

    /**
     * 找到一条从根节点到叶子节点的路径，使这个路径的节点总和等于targetSum
     * @param root 根节点
     * @param targetSum 目标值
     * @return 布尔值，找到返回真，找不到返回假
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left,targetSum- root.val)
                || hasPathSum(root.right,targetSum-root.val);
    }
}
