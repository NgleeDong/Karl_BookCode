import java.util.ArrayList;
import java.util.List;

public class Lc77_combine {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    /**
     * 递归函数（回溯）
     * @param n 1-n的数
     * @param k k个数的组合
     * @param startNumber 从哪个数字开始
     */
    public static void process(int n, int k, int startNumber) {
        //base case
        if (path.size() == k) { //当前的path满足题目条件了，放到结果集中
            result.add(new ArrayList<>(path));
            //为什么这么写？因为Java的集合 存的是 引用类型的地址！！！！！，不这样写都会一样
            //也就是说，ArrayList的add函数做的是浅拷贝
            System.out.println("result.toString() = " + result.toString());
            return;
        }
//        for (int i = startNumber; i <= n; i++) {
//            path.add(i);
//            process(n, k, i + 1);//递归
//            path.remove(path.size()-1);//回溯，撤销处理的节点
//        }
        //剪枝
        for (int i = startNumber; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            System.out.println("path.toString()11 = " + path.toString());
            process(n, k, i + 1);//递归
            path.remove(path.size()-1);//回溯，撤销处理的节点
            System.out.println("path.toString()22 = " + path.toString());
        }
    }

    //lc77：组合
    public static List<List<Integer>> combine(int n, int k) {
        process(n, k, 1);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);
        System.out.println("lists.toString() = " + lists.toString());
    }
}
