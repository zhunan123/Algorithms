package chapterThreeLinkedList;

public class DeletNodeWithoutHead {
    public void deleteNode(ListNode node) {
        //1->2->3->4->null 3, 把3的下一个4复制给你，然后再吧4去掉，就相当于去掉了3
        if(node == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
