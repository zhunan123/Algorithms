package CS545.linkedlistEasyMedium;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
