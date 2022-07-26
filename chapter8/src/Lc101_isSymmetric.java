public class Lc101_isSymmetric {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compareLeftRight(root.left,root.right);
    }

    public static boolean compareLeftRight(TreeNode L,TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null && R != null) return false;
        if (L != null && R == null) return false;
        //否则都非空
        if ( L.val == R.val && compareLeftRight(L.left,R.right) && compareLeftRight(L.right,R.left)) {
            return true;
        }
        return false;
    }
}
