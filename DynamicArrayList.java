import java.util.ArrayList;

public class DynamicArrayList {
    /**
     * @param n: You should generate an array list of n elements.
     * @return: The array list your just created.
     */
    public ArrayList<Integer> create(int n) {
        // Write your code here
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            al.add(i);
        }
        return al;
    }

    /**
     * @param list: The list you need to clone
     * @return: A deep copyed array list from the given list
     */
    public ArrayList<Integer> clone(ArrayList<Integer> list) {
        // Write your code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i< list.size();i++) {
            al.add(list.get(i));
        }
        return al;
    }

    /**
     * @param list: The array list to find the kth element
     * @param k: Find the kth element
     * @return: The kth element
     */
    public int get(ArrayList<Integer> list, int k) {
        // Write your code here
        return list.get(k);
    }

    /**
     * @param list: The array list
     * @param k: Find the kth element, set it to val
     * @param val: Find the kth element, set it to val
     */
    public void set(ArrayList<Integer> list, int k, int val) {
        // write your code here
        list.set(k, val);
    }

    /**
     * @param list: The array list to remove the kth element
     * @param k: Remove the kth element
     */
    public void remove(ArrayList<Integer> list, int k) {
        // write tour code here
        list.remove(k);
    }

    /**
     * @param list: The array list.
     * @param val: Get the index of the first element that equals to val
     * @return: Return the index of that element
     */
    public int indexOf(ArrayList<Integer> list, int val) {
        // Write your code here
        return list.indexOf(val);
    }
}
