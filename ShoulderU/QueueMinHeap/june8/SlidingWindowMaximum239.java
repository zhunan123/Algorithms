package ShoulderU.QueueMinHeap.june8;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // brute force - not good
        // create maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // create ans array
        List<Integer> list = new ArrayList<>();

        // loop from nums array
        for (int i = 0; i < nums.length - k + 1; i++){
            // add the first k element starting from i into maxHeap
            for (int j = i; j < i + k; j++) {
                maxHeap.offer(nums[j]);
            }

            // poll() maxvalue from the maxHeap
            list.add(maxHeap.poll());
            // clear the maxHeap
            maxHeap.clear();
        }

        // convert arrayList to int[]
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

