package ShoulderU.Array.july13;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public int minMeetingRooms(int[][] intervals) {
        // sort 每个interval start
        // 如果有interval的话就要增加房间
        // 但是是找minimum 房间，所以要遍历之前的房间，看看几点后才空着（从有没有interval来判断(当前meeting开始时间和之前时间的endtime)，有interval就代表不行），去查找是不是有房间已经空了，然后再利用已经空了的房间来达到minimum room
        // min heap will keep trach of the ending showing time when there is a meeting room gets available
        // sort，初始化minheap，吧第一个放进去，从第二个开始比较，如果没有interval，说明不用增加room，就先poll minheap然后吧第二个时间段放进来，如果有interval，那就不poll，直接加进minheap，
        // min heap存的是所有房间的结束最早时间，所以不用遍历，只用比较这个minheap top 的最早结束时间

        // idea: 初始化heap，排序，把第一个时间段加进来，minheap will kepp track earliest ending time, 从第二个时间段开始loop，每一个当前interval和minheap的最早结束时间比较，if有interval，那就吧当前interval直接加入heap，means need to start another room，if no 重叠interval with min heap top earliest endtime，means that min heap top room is already empty, so poll it, add the current interval into it, the min heap will automatically update the current earliest ending time, then loop until its end, then do a heap.size to find the minimum room

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int earliestEndingTime = minHeap.peek();
            if (intervals[i][0] >= earliestEndingTime) {
                // 更新minheap top
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            } else {
                minHeap.add(intervals[i][1]);
            }
        }

        return minHeap.size();
    }
}
