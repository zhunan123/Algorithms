package ShoulderU.Array.july10;

import java.util.Arrays;

public class MeetingRooms252 {
  public boolean canAttendMeetings(int[][] intervals) {
    // idea：就在那边会的开始时间一字排序，interval[i][0] 进行排序，然后找一下有没有inteval，有就是false，没有就是true
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i - 1][1]) {
        return false;
      }
    }
    return true;
  }
}
