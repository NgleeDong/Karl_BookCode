import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lc817_numComponents {

    /*
    Lc817. 链表组件
     */

    /**
     * 方法二：直接操作链表，比较快
     */
    public static int numComponents1(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        boolean flag = false;
        ListNode p1 = head;
        while (p1 != null) {
            if (set.contains(p1.val)) {
                if (flag) {
                    p1 = p1.next;
                    continue;
                }
                count++;
                flag = true;
            } else {
                flag = false;
            }
            p1 = p1.next;
        }
        return count;
    }


    /**
     * 方法一
     * 先把 链表--->数组，再处理
     */
    public static int numComponents(ListNode head, int[] nums) {
        List<Integer> list = new ArrayList<>();
        ListNode p1 = head;
        while (p1 != null) {
            list.add(p1.val);
            p1 = p1.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        //此时有两个数组 arr、nums
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                if (flag) continue;
                count++;
                flag = true;
            } else {
                flag = false;
            }
        }
        return count;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
