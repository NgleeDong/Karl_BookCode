public class Lc111_minDepth {

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        //向左树要信息
        int leftDepth = minDepth(root.left);
        //向右树要信息
        int rightDepth = minDepth(root.right);

        //根据信息处理
        //情况1: 左树为空,右树不为空,这时最小深度是对应的右树的最小深度加1
        if (root.left == null && root.right != null) return rightDepth + 1;
        //情况2: 右树为空,左树不为空,这时最小深度是对应的左树的最小深度加1
        if (root.right == null && root.left != null) return leftDepth + 1;
        //当左右子树都不为空是要求的是两个子树的最小高度
        return Math.min(leftDepth,rightDepth) + 1;
    }

}
