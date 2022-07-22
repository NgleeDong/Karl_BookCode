
public class TestLinkedList {

    public static void main(String[] args) {
        Lc707_MyLinkedList linkedList = new Lc707_MyLinkedList();
        linkedList.printMyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.printMyLinkedList();


        linkedList.addAtIndex(3,0);   //链表变为1-> 2-> 3
        linkedList.printMyLinkedList();

        linkedList.deleteAtIndex(2);  //现在链表是1-> 3
        linkedList.printMyLinkedList();

        linkedList.addAtHead(6);
        linkedList.printMyLinkedList();

        linkedList.addAtTail(4);
        linkedList.printMyLinkedList();


//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.printMyLinkedList();

        System.out.println(linkedList.get(4));            //返回2


//        System.out.println(linkedList.get(1));            //返回3

    }
}
