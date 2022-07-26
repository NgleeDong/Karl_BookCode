public class Lc110_isBalanced {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    //可能性是什么？
    //一棵树是平衡二叉树要求：（三个条件都成立）
    //1、左子树平衡
    //2、右子树平衡
    //3、|左高-右高| <= 1
    /*
    左树信息：是否平衡？高度？
    右树信息：是否平衡？高度？
     */
    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    //返回值的结构，即我向左右子树要的信息
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced,int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(TreeNode node) {
        // Base case
        if (node == null) {
            return new ReturnType(true,0);
        }
        //左树返回两个信息(当做黑盒)
        ReturnType leftData = process(node.left);
        //右树返回两个信息(当做黑盒)
        ReturnType rightData = process(node.right);
        //我也得返回两个信息
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) <= 1;
        return new ReturnType(isBalanced,height);
    }
}
