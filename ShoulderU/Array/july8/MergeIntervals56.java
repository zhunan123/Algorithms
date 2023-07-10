package ShoulderU.Array.july8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
  public int[][] merge(int[][] intervals) {
    // idea 组关键的是先把当前currentIntervalArray加进来array list，然后之后再去更新currentIntervalArray的东西通过之后的比较，也就是通过reference copy来update currentIntervalArray
    // need to sort int[][0] first, 确保int[]的第一位是sort的
    // 把第一个array当作currentIntervalArray,然后把currentIntervalArray加入ans list里面。 然后比较第二个array的第一个和currentIntegervalArray的第二个，如果小的话，就说明有inteval，然后currentIntevalArray的第二个就是取currentIntevalArray的第2个和第二个array的第2个的最大值，
    //若是第二个array的第一个大于currentIntevalArray的第二个，就说明是独立的，把currentIntevalArray成第二个array, 然后加进来ans array里
    // need to sort int[][0] first
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> res = new ArrayList<>();
    int[] currentIntervalArray = intervals[0];
    // 要把currentIntervalArray加进来ans list
    res.add(currentIntervalArray);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= currentIntervalArray[1]) {
        currentIntervalArray[1] = Math.max(currentIntervalArray[1], intervals[i][1]);
      } else {
        currentIntervalArray = intervals[i];
        res.add(currentIntervalArray);
      }
    }
    return res.toArray(new int[][]{});
  }
}
