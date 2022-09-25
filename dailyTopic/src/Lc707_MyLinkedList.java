public class Lc707_MyLinkedList {
    int size; // size 存储链表的元素个数
    ListNode dummyNode;//虚拟头结点

    //初始化链表
    public Lc707_MyLinkedList() {
        size = 0;
        dummyNode = new ListNode(0);
    }

    //index从0开始
    public int get(int index) {
        if (index < 0 || index >= size) { //索引无效
            return -1;
        }
        //从前往后遍历
        int i = -1;
        ListNode p = dummyNode;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        //创建这个节点
        ListNode head = new ListNode(val);
        //插入到虚拟节点之后
        head.next = dummyNode.next;
        dummyNode.next = head;
        size++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     */
    public void addAtTail(int val) {
        //创建这个节点
        ListNode tailNode = new ListNode(val);
        //遍历
        ListNode p = dummyNode;
        while (p.next != null) {
            p = p.next;
        }
        //插入
        p.next = tailNode;
        size++;
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        }else if (index < 0) {
            addAtHead(val);
            return;
        } else if (index >= size) {
            return;
        } else {
            //创建这个节点
            ListNode node = new ListNode(val);
            //找到第index个节点之前的节点
            int i = -1;
            ListNode p = dummyNode;
            while (i != index - 1) {
                p = p.next;
                i++;
            }
            //插入
            node.next = p.next;
            p.next = node;
            size++;
            return;
        }
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        //找到第index个节点 的前一个节点
        int i = -1; //从虚拟节点开始
        ListNode p = dummyNode;
        while (i != index - 1) {
            p = p.next;
            i++;
        }
        p.next = p.next.next;
        size--;
    }
}

/**
 * 链表节点定义
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
