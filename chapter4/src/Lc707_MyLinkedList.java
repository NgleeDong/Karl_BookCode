/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：
 * val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Lc707_MyLinkedList {
    int size;//size存储链表元素的个数
    ListNode dummyNode; //虚拟头结点

    //初始化链表
    public Lc707_MyLinkedList() {
        size = 0;
        dummyNode = new ListNode(0);
    }


    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = dummyNode.next;//指向index为0的节点
        while (index != 0) {
            cur = cur.next;//后移
            index--;
        }
        return cur.val;
    }

    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        //创建这个节点
        ListNode newNode = new ListNode(val);
        if (dummyNode.next == null) { //如果当前链表为空
            dummyNode.next = newNode;
            size++;
            return;
        }
        newNode.next = dummyNode.next;
        dummyNode.next = newNode;
        size++;
        return;
    }

    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        //创建这个节点
        ListNode tailNode = new ListNode(val);
        ListNode cur = dummyNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        //此时cur指向当前链表最后一个节点
        cur.next = tailNode;
        size++;
        return;
    }

    //addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index > size) return;
//        if (index < 0) addAtHead(val);
//        if (index == size) addAtTail(val);

        ListNode node = new ListNode(val);
        //找到插入位置之前的节点
        ListNode preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        //此时preNode为插入位置之前的节点
        node.next = preNode.next;
        preNode.next = node;
        size++;
        return;
    }

    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) { //索引无效
            return;
        }

        //找到删除位置之前的节点
        ListNode preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        //此时preNode为删除位置之前的节点
        preNode.next = preNode.next.next;
        size--;
        return;
    }

    public void printMyLinkedList() {
        ListNode cur = dummyNode;
        while (cur.next != null) {
            System.out.print(cur.next.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
