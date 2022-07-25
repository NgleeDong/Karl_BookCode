import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc144_preorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderNonRecursive(root,list);
        return  list;
    }

    /**
     * 二叉树的前序遍历：非递归方式
     * 根 左 右
     */
    public static void preOrderNonRecursive(TreeNode root,List<Integer> list) {
        if (root == null) return;
        //准备一个栈
        Stack<TreeNode> stack = new Stack<>();
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popTeeNode = stack.pop(); //弹栈并处理
            list.add(popTeeNode.val);
            //先压右在压左
            if (popTeeNode.right != null) stack.push(popTeeNode.right);
            if (popTeeNode.left != null) stack.push(popTeeNode.left);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        
        root.right = node1;
        node1.left = node2;

        List<Integer> list = preorderTraversal(root);
        System.out.println("list.toString() = " + list.toString());
    }
}
