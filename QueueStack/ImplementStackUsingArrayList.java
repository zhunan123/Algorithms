package QueueStack;

import java.util.ArrayList;

public class ImplementStackUsingArrayList {
    //implement using the arrayList
    ArrayList<Integer> arr = new ArrayList<>();
    public void push(int x) {
        // write your code here
        arr.add(x);
    }

    public void pop() {
        int len = arr.size();
        if(len > 0){
            arr.remove(arr.get(len - 1));
        }
    }

    public int top() {
        int len = arr.size();
        if(len > 0){
            return arr.get(len - 1);
        }
        return -1;
    }

    public boolean isEmpty() {
        if(arr.size() == 0){
            return true;
        }
        return false;
    }
}
