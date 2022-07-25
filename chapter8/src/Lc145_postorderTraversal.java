import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc145_postorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderNonRecursive(root,list);
        return list;
    }

    /**
     * 二叉树的后序遍历：非递归方式
     * 左 右 根
     */
    public static void postOrderNonRecursive(TreeNode root,List<Integer> list) {
        if (root == null) return;
        //准备一个栈
        Stack<TreeNode> stack = new Stack<>();
        //准备一个收集栈
        Stack<Integer> collStack = new Stack<>();
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popTeeNode = stack.pop(); //弹栈并处理
            //处理：放入收集栈中,只放数值即可
            collStack.push(popTeeNode.val);
            //先压左在压右
            if (popTeeNode.left != null) stack.push(popTeeNode.left);
            if (popTeeNode.right != null) stack.push(popTeeNode.right);

        }
        //从收集栈中依次弹出，并放入list中
        while (!collStack.isEmpty()) {
            list.add(collStack.pop());
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        List<Integer> list = postorderTraversal(root);
        System.out.println("list.toString() = " + list.toString());
    }
}
