package week5.nestedClass.AnonymousClass;

import java.util.Comparator;

public class ComparatorByBattingAverage implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {

        int result = o1.toString().compareTo(o2.toString());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
