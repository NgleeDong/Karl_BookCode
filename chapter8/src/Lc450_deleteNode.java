public class Lc450_deleteNode {

    //删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) { //删除的是叶子结点
                root = null;
            }
            //删除的不是叶子结点
            if (root.left == null) { //左孩子为空，右孩子不空
                return root.right;
            } else if (root.right == null) { //右孩子为空，左孩子不空
                return root.left;
            } else { //左右孩子都不空，需要找到右子树最左下的
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                //将root的左孩子接到 右子树最左下 的左孩子上
                node.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
