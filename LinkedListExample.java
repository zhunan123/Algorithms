class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class LinkedListExample {
    public static void main(String[] args){
//        runLinkedListExample();

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 2);
        myLinkedList.add(2, 3);
        myLinkedList.add(3, 4);

        myLinkedList.update(0, 100);
        myLinkedList.remove(2);

        for (int i=0; i<4; i++){
            System.out.println(myLinkedList.get(i) + " ");
        }
    }

    public static void runLinkedListExample(){
        //create a listNode node's object, and save its address inside node1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //traverse the linked list
        ListNode cur = node1;
        while (cur != null){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
    }
}
