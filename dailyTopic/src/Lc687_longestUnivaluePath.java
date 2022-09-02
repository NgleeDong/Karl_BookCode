

public class Lc687_longestUnivaluePath {

    /**
     * lc687：最长同值路径
     * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 两个节点之间的路径长度由它们之间的边数表示
     */

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        process(root, root.val);
        return maxLength;
    }

    int maxLength = 0;

    public int process(TreeNode node, int parentVal) {
        if (node == null) return 0;
        //向左子树要信息
        int leftPath = process(node.left, node.val);
        //向右子树要信息
        int rightPath = process(node.right, node.val);
        //维护一个全局变量
        maxLength = Math.max(maxLength, leftPath + rightPath);
        if (node.val == parentVal) { // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(leftPath, rightPath) + 1;
        }
        return 0;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


