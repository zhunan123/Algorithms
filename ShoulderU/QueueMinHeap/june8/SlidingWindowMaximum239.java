package ShoulderU.QueueMinHeap.june8;

import java.util.ArrayDeque;
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


// using deque arrayDeque, logic has some error
/**
 * initilize a queue, keep the queue in a decreasing way,
 * before adding the new element, while the previous element is smaller so we can remove previous one,
 * if the previous element after remove is still smaller then we keep removing,  and add the new element,
 * but if is smaller, we dont need to remove previous one and just add the current one,
 * and when we have a queue size of k, we dequeue at the front max value;
 * */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // create double ended queue
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // create ans list
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // remove elemenyt fron the front that has index outside of the sliding window
            while (!deque.isEmpty() && deque.peekFirst()  < i - k + 1) {
                deque.removeFirst();
            }

            // if current greater than last one in deque, so we remove previous
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            // add current to deque, and if current is smaller than previous also we add to deque
            deque.addLast(nums[i]);

            // if we have a deque size of k, remove front and add to ans list
            if (i >= k - 1) {
                ans.add(deque.peekFirst());
            }
        }

        // convert arraylist to int[];
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}

