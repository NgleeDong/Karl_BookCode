public class Lc235_lowestCommonAncestor {

    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //思路：BST是有序的，从上往下遍历的过程中，如果某个节点的值在[p,q]之间，则它是p、q的LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val) ) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null ? left : right;
    }
}
