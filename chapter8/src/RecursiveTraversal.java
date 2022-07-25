import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversal {
    /**
     * 二叉树的递归遍历
     */
    public static List<Integer> recursiveTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderRecursiveTraversal(root,list);//前序遍历
        return list;
    }

    //1.前序遍历递归写法
    public static void preOrderRecursiveTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrderRecursiveTraversal(root.left,list);
        preOrderRecursiveTraversal(root.right,list);
    }
    //2.中序遍历递归写法
    public static void inOrderRecursiveTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderRecursiveTraversal(root.left,list);
        list.add(root.val);
        inOrderRecursiveTraversal(root.right,list);
    }
    //3.后序遍历递归写法
    public static void postOrderRecursiveTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrderRecursiveTraversal(root.left,list);
        postOrderRecursiveTraversal(root.right,list);
        list.add(root.val);
    }
}
