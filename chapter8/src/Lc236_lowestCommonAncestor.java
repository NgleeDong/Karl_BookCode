import java.util.HashMap;
import java.util.HashSet;

public class Lc236_lowestCommonAncestor {


    // 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。LCA问题
    //方法一：
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> fatherMap = new HashMap<>();//key:当前节点 value:它的父节点
        fatherMap.put(root,root);//为了处理方便，我们认为root的父节点就是root
        traverse(root,fatherMap);

        HashSet<TreeNode> set1 = new HashSet<>(); //存储root->p链路上的所有节点
        TreeNode curNode = p;
        while (curNode != fatherMap.get(root)) { //未到根节点
            set1.add(curNode);
            curNode = fatherMap.get(curNode);
        }
        set1.add(root); //把根节点也加进去

        curNode = q;
        //当q往上走的过程中，如果某个节点在Set中，则它是p、q的最低公共祖先
        while (curNode != fatherMap.get(root)) { //未到根节点
            if (set1.contains(curNode)) {
                return curNode;
            } else {
                curNode = fatherMap.get(curNode);
            }
        }

        return root;
    }

    public void traverse(TreeNode root, HashMap<TreeNode,TreeNode> fatherMap) {
        if (root == null) return;
        if (root.left != null) fatherMap.put(root.left,root);
        if (root.right != null) fatherMap.put(root.right,root);
        traverse(root.left,fatherMap);
        traverse(root.right,fatherMap);
    }

    //方法二:比较抽象
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q); //向左树要信息
        TreeNode right = lowestCommonAncestor2(root.right, p, q); //向右树要信息
        if (left != null && right != null) {
            return root;
        }
        //左右两棵树，并不都有返回值：有一个不空，返回不空的那个；都空，返回空
        return left != null ? left : right;
    }
}
