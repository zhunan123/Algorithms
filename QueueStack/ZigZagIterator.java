package QueueStack;

import java.util.*;

public class ZigZagIterator {

    Queue<Iterator<Integer>> queue = new LinkedList<>();
    public void ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        for(List<Integer> vec : vecs){
            if(vec.size() > 0){
                queue.offer(vec.iterator());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if(!hasNext()) {
            return -1;
        }
        Iterator<Integer> it = queue.poll();
        int nextInt = it.next();

        if(it.hasNext()){
            queue.offer(it);
        }

        return nextInt;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return !queue.isEmpty();
    }

    public static void main(String[] args){
        ZigZagIterator zig = new ZigZagIterator();
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        zig.ZigzagIterator2(list);
        zig.next();
    }
}
