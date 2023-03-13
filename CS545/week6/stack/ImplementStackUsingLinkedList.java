package CS545.week6.stack;

public class ImplementStackUsingLinkedList {

    //beginning of linkedlist (linkedlist head) is the top of stack

    private class Node {
        private Object data;
        private Node next;

        public Node(Object newElem) {
            data = newElem;
            next = null;
        }

        public Node(Object newElem, Node newNext) {
            data = newElem;
            next = newNext;
        }

        public Node next() {
            return next;
        }

        public Object elem() {
            return data;
        }
    }


    private Node top;

    public ImplementStackUsingLinkedList() {
        top = null;
    }

    public void push(Object elem) {
        Node newNode = new Node(elem);
        newNode.next = top;
        top = newNode;
    }

    public boolean empty() {
        return top == null;
    }

    public Object pop(){
        Object poppedValue;
        if (top == null) {
            return null;
        }

        poppedValue = top.elem();
        top = top.next();
        return poppedValue;
    }
}
