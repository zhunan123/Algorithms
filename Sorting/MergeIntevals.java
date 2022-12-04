package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeIntevals {

    /**
     * 我们以一个 Interval 类型的列表 intervals 来表示若干个区间的集合，其中单个区间为 (start, end)。
     * 你需要合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 输入:  [(1,3),(2,6),(8,10),(15,18)]
     * 输出: [(1,6),(8,10),(15,18)]
     * */

      public class Interval {
        int start, end;
        Interval(int start, int end) {
          this.start = start;
          this.end = end;
        }
      }

    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort((o1, o2) -> o1.start - o2.start);

        List<Interval> ret = new ArrayList<>();

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ret.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }

        return ret;
    }
}
