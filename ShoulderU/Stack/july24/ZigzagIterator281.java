package ShoulderU.Stack.july24;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator281 {
    // use 2 pointer
    List<Integer> list = new ArrayList<>();
    int pointerIndex = 0;

    public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {
        int p1 = 0, p2 = 0;
        int n = 0;
        while (p1 < v1.size() || p2 < v2.size()) {
            if (p1 >= v1.size()) {
                list.add(v2.get(p2));
                p2++;
            } else if (p2 >= v2.size()) {
                list.add(v1.get(p1));
                p1++;
            } else {
                if (n % 2 == 0) {
                    list.add(v1.get(p1));
                    p1++;
                } else {
                    list.add(v2.get(p2));
                    p2++;
                }
            }
            n++;
        }
    }

    public int next() {
        int res = list.remove(pointerIndex); // when remove automatically update pointerIndex
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
