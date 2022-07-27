import java.util.ArrayList;
import java.util.List;

public class Lc257_binaryTreePaths {

    /**
     * 给定一颗二叉树，返回其所有路径
     * @param root 根节点
     * @return List<String>
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        process(root,"",list);
        return  list;
    }

    /**
     * 递归函数
     * @param node 当前来到的节点
     * @param path 记录路径
     * @param list list容器接受结果
     */
    public static void process(TreeNode node, String path, List<String> list) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) { //node是叶子结点
            //把当前路径加到存储路径list容器中
            list.add(path);
        } else { //node不是叶子结点
            process(node.left,path + "->",list);
            process(node.right,path + "->",list);
        }
    }
}
