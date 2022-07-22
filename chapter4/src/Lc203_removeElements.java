public class Lc203_removeElements {

    //内部类
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        //添加一个虚拟头节点
        ListNode virtualHead = new ListNode(0,head);
        head = virtualHead;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return virtualHead.next;
    }


    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(6);
        ListNode node6 = new ListNode(5,node7);
        ListNode node5 = new ListNode(4,node6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        System.out.println("移除6前:");
        printList(node1);

        ListNode node = removeElements(node1, 6);

        System.out.println("移除6后:");
        printList(node);

    }
}
