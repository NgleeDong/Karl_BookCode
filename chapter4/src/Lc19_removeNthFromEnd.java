public class Lc19_removeNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟节点
        ListNode dummyNode = new ListNode(0,head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        //fast先走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) { //同时移动
            fast = fast.next;
            slow = slow.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;
        return dummyNode.next;
    }

}
