import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc102_levelOrder {

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderByQueue(root,lists);
        return lists;
    }

    public static void levelOrderByQueue(TreeNode root, List<List<Integer>> lists) {
        if (root == null) return;
        //准备一个队列
        Queue<TreeNode> queue = new LinkedList<>(); //java中队列是LinkedList实现的
        //根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode pollNode = queue.poll();
                levelList.add(pollNode.val);
                if (pollNode.left != null) queue.offer(pollNode.left);
                if (pollNode.right != null) queue.offer(pollNode.right);
                len--;
            }

            lists.add(levelList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> lists = levelOrder(root);
        System.out.println("lists.toString() = " + lists.toString());
    }
}
