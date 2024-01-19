package LinkedList;

import java.util.HashMap;

public class CopyListwithRandomPointer138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // loop 1 copy all codes, loops 2 assign next and random pointers to deep copy
        if (head == null) return null;

        Node current = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
