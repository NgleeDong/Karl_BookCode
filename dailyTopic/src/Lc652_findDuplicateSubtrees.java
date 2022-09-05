import java.util.*;

public class Lc652_findDuplicateSubtrees {

    /**
     * lc652. 寻找重复的子树
     */

    Map<String, TreeNode> map = new HashMap<>();//需要使用一个哈希映射 map 存储序列到子树的映射
    Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        process(root);
//        System.out.println(set.toString());
        return new ArrayList<>(set);
    }

    public String process(TreeNode node) {
        if (node == null) return "#";
        StringBuilder sb = new StringBuilder();
        //将二叉树序列化
        sb.append(node.val)
                .append(",")
                .append(process(node.left))
                .append(",")
                .append(process(node.right));
        String s = sb.toString();
        if (map.containsKey(s)) { //如果map中存在了，说明此时有重复的
            set.add(map.get(s));
        } else {
            map.put(s, node);
        }
        return s;
    }
}
