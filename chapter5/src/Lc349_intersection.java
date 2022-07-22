import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Lc349_intersection {

    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        System.out.println(set);

        for (int j = 0; j < nums2.length; j++) {
            int n = nums2[j];
            if (set.contains(n)) { //如果set中有这个数
                list.add(n); //就添加到list中
                set.remove(n); //set集合中remove掉！！
            }
        }

        System.out.println(list);

        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        return arr;
    }


    public static int[] intersection1(int[] nums1, int[] nums2) {


        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
//        System.out.println(set2);
        //此时set2中放的就是交集
        int[] res = new int[set2.size()];
        int index = 0;
        for (int num : set2) {
            res[index++] = num;
        }

        return res;

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,3,6,2,1};
        int[] nums2 = {3,3,1};
        int[] res = intersection1(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
