public class ReferenceManager {

    public void copyValue(Node obj) {
        if (obj != null){
            Node node1 = new Node(obj.value);
            //create new object and different address
        }
    }

    public void copyReference(Node obj){
        Node node1 = obj; //reference, 2object share same address
    }
}

class Node {
    public int value;
    public Node(int value) {
        this.value = value;
    }
}
