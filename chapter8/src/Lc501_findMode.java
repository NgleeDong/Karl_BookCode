import java.util.*;

public class Lc501_findMode {

    //给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）
    //方法一：对于一颗普通的二叉树也可以做
    public static int[] findMode(TreeNode root) {
        searchBST(root);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //输出一下map
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
//        }
        //将map根据val进行排序（从大到小）
        //建立一个大根堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(((o1, o2) -> o2.getValue()- o1.getValue()));
        //将map中每个元素放入大根堆中
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
        }
        //弹出大根堆中最大的那个Entry
        Map.Entry<Integer, Integer> poll = queue.poll();
        ArrayList<Integer> list = new ArrayList<>();
        int maxCount = poll.getValue(); //最大的出现次数
        list.add(poll.getKey());
        //遍历剩下的大根堆
        int queueLength = queue.size();
        for (int i = 0; i < queueLength; i++) {
            Map.Entry<Integer, Integer> pollEntry = queue.poll();
            if (pollEntry.getValue() == maxCount) { //若当前弹出的Entry的频数 == 最大的出现次数
                list.add(pollEntry.getKey());
            } else {
                break;
            }
        }
        //把list转换成array返回
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            array[i++] = integer;
        }
        return array;
    }

    static Map<Integer,Integer> map = new HashMap<>(); //key存储值，value存储出现的次数
    public static void searchBST(TreeNode node) {
        if (node == null) return;
        int key = node.val;
        if (map.containsKey(key)) { //map包含此key
            int count = map.get(key);
            map.put(key, ++count);
        } else { //map不包含此key
            map.put(key,1);
        }
        searchBST(node.left);
        searchBST(node.right);
    }

    //方法二：针对BST
//    中序遍历会得到一个排序数组，考虑在一个排序的数组中查找出现次数最多的数字，可以在遍历时记录这个数字出现的次数。
//    当新的数字与前一个数字不同，则根据这个数字出现的次数
        //    如果 小于 最大次数，不用管
        //    如果 等于 最大次数，加入到答案列表中
        //    如果 大于 最大次数，清空答案列表，然后加入这个数字，并更新最大次数
    public static int[] findMode2(TreeNode root) {
        inOrderBST(root);
        //把list转换成array返回
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            array[i++] = integer;
        }
        return array;
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static int maxCount = Integer.MIN_VALUE;//最大频率
    static int curCount = 0; //当前遍历的数的频率
    static TreeNode preNode;//前一个node
    public static void inOrderBST(TreeNode node) {
        if (node == null) return;
        inOrderBST(node.left);//左
        //中
        //判断和上一个节点的关系
        if (preNode ==null) { //第一个节点
            curCount = 1;
        } else if (preNode.val == node.val) { // 与前一个节点数值相同
            curCount++;
        } else { // 与前一个节点数值不同
            curCount = 1;
        }
        //更新上一个节点
        preNode = node;
        //判断当前数量与最大数量的关系, 更新 list 和 maxCount
        if (curCount == maxCount) { // 如果和最大频率值相同，放进list中
            list.add(node.val);
        }
        if (curCount > maxCount) { // 如果大于最大频率值
            maxCount = curCount; //更新最大频率值
            list.clear();//清空list，之前list里的元素都失效了
            list.add(node.val);
        }
        inOrderBST(node.right);//右
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(6);
//        TreeNode node5 = new TreeNode(6);
//        root.right = node1;
//        node1.right = node2;
//        node2.right = node3;
//        node3.right = node4;
//        node4.right = node5;

        int[] mode = findMode2(root);
        System.out.println("Arrays.toString(mode) = " + Arrays.toString(mode));
    }
}
