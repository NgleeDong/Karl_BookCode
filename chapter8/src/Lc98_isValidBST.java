import java.util.ArrayList;
import java.util.Iterator;

public class Lc98_isValidBST {

    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
    public boolean isValidBST(TreeNode root) {
//        inOrder(root);
//        return listIsIncrease(list);
        return isBST(root);
    }

    //方法一：
    ArrayList<Integer> list = new ArrayList();
    //利用二叉搜索树的中序遍历是个递增的序列
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public boolean listIsIncrease(ArrayList<Integer> list) {
        boolean flag = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i+1)) { //注意：此处是>=，有等号的！因为搜索树是严格的> <
                flag = false;
            }
        }
        return flag;
    }

    //方法二：
    TreeNode pre = null;
    public boolean isBST(TreeNode root) {
        if (root == null) return true;
        if (!isBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isBST(root.right);
    }
}
