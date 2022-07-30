import java.util.HashMap;
import java.util.Map;

public class Lc106_buildTree {

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
     * 请你构造并返回这颗二叉树
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return process(inorder,postorder,0,len-1,0,len-1);
    }

    public TreeNode process(int[] inorder, int[] postorder, int inBegin, int inEnd, int pBegin, int pEnd) {
        //base case
        if (pBegin > pEnd) {
            return null;
        }

        int post_root = pEnd;
        int in_root = map.get(postorder[post_root]);
        int num = in_root - inBegin;//左子树的数量

        TreeNode root = new TreeNode(postorder[post_root]);

        root.left = process(inorder,postorder,inBegin,in_root-1,pBegin,pBegin+num-1);
        root.right = process(inorder,postorder,in_root+1,inEnd,pBegin+num,pEnd-1);

        return root;
    }
}
