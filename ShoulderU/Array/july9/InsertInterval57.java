package ShoulderU.Array.july9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    // idea 把之前的都先加进来，先找到newInteverval要插入的位置，设置插入前一个为currentInterval，加入result list，如果newInterval的0 小于currentInterval的1，就合并，要么就是update新currentInterval并加入，然后loop到最后

    // correct idea: write a function to insert the newInterval into intervals and return intervals list,  then handle it with normal merge intervals
    List<int[]> res = new ArrayList<>();
    // edge case
    if (intervals.length == 0) {
      res.add(newInterval);
      return res.toArray(new int[][]{});
    }
    List<int[]> list = insert(newInterval, intervals);
    // then handle it with normal array merge
    int[] currentInterval = list.get(0);
    res.add(currentInterval);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i)[0] <= currentInterval[1]) {
        currentInterval[1] = Math.max(currentInterval[1], list.get(i)[1]);
      } else {
        currentInterval = list.get(i);
        res.add(currentInterval);
      }
    }
    return res.toArray(new int[][]{});
  }

  public List<int[]> insert(int[] newInterval, int[][] intervals) {
    List<int[]> res = new ArrayList<>(Arrays.asList(intervals));

    // add ar front
    if (intervals[0][0] > newInterval[0]) {
      res.add(0, newInterval);
      return res;
    }
    // add at end
    if (res.size() >= 2 && (intervals[res.size() - 1][0] < newInterval[0])) {
      res.add(res.size(), newInterval);
      return res;
    }

    // edge conditon
    if (res.size() == 1) {
      if (res.get(0)[0] < newInterval[0]) {
        res.add(1, newInterval);
        return res;
      } else {
        res.add(0, newInterval);
        return res;
      }
    }

    // add middle
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= newInterval[0]) {
        res.add(i, newInterval);
        break;
      }
    }
    return res;
  }
}
