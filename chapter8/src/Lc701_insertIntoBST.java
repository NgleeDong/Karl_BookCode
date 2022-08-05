public class Lc701_insertIntoBST {

    //二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val > val) { //搜左子树
            root.left = insertIntoBST(root.left,val);
        }
        if (root.val < val) { //搜右子树
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
