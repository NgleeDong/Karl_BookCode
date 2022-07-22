/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

public class Lc206_reverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next; //保存cur的下一个节点
            cur.next = pre;
            //更新pre和cur
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
