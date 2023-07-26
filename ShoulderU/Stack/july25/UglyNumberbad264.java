package ShoulderU.Stack.july25;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberbad264 {
    public int nthUglyNumber(int n) {
        // idea: create int[] then just loop n and adding new ugly number to int[] then just return the last one
        // start from second number which is 2..
        int num = 2;
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        while (list.size() < n) {
            if(isUgly(num)) {
                list.add(num);
            }
            num++;
        }
        return list.get(n - 1);
    }

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
