import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc94_inorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderNonRecursive(root,list);
        return  list;
    }

    /**
     * 二叉树的中序遍历：非递归方式
     * 左 根 右
     */
    public static void inOrderNonRecursive(TreeNode root,List<Integer> list) {
        if (root == null) return;
        //准备一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) { //左边界全入栈
                stack.push(node);
                node = node.left;
            } else {
                //左边界依次弹出
                node = stack.pop();
                //弹出后处理
                list.add(node.val);
                //对弹出的右树重复上述操作
                node = node.right;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        List<Integer> list = inorderTraversal(root);
        System.out.println("list.toString() = " + list.toString());
    }
}
