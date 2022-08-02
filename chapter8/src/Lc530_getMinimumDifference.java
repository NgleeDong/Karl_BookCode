import java.util.ArrayList;

public class Lc530_getMinimumDifference {

    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return getMin(list);
    }

    ArrayList<Integer> list = new ArrayList<>();
    //利用BST的中序遍历是递增的
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public int getMin(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i+1) - list.get(i);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }
}
