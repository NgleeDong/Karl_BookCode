import java.util.HashMap;
import java.util.Map;

public class Lc105_buildTree {

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历 ， inorder是同一棵树的中序遍历 ，
     * 请你构造并返回这颗二叉树
     *
     * 来源：力扣（LeetCode）
     */

    private Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return process(preorder,inorder,0,len-1,0,len-1);
    }

    public TreeNode process(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        //base case
        if (preBegin > preEnd) return null;

        int pre_root = preBegin;//当前 根节点在preorder数组中的下标
        int in_root = map.get(preorder[pre_root]);//当前 根节点在inorder数组中的下标
        int num = in_root - inBegin; //左子树的节点个数

        TreeNode root = new TreeNode(inorder[in_root]);

        root.left = process(preorder,inorder,preBegin+1,preBegin+num,inBegin,in_root-1);
        root.right = process(preorder,inorder,preBegin+num+1,preEnd,in_root+1,inEnd);

        return root;
    }
}
