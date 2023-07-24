package ShoulderU.Stack.july24;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // if in the window we see a value that is greater than previous value in the window, then we can eliminate those previous values in the window.
        // idea: using deque, and the deque will always be decreasing order.  if value if not greater then top(last) of deque, push it, but if value is greater then deque top(last), pop the deque top(last) off, then make the comparsion again the value with the deque top, if the value if still greater, pop the deque top, until the deque is empty we stop and add the current value to deque. then add current to output array and go to next value, repeat previous step\

        // example [8,7,6,9] k =2 ---> they are in decreasing order so call monotonically queue
        //in the deque first add 8, then go to 7 since 7 is smaller, add 7 to deque, then since we reached k we can just add left most value(8) to the output array since its a descreasing monotonically queue, then 98 is no longer in bound, we pop 8, next is 6, 6 is smaller then 7, so we add 6, then we reached size 2, add left most value which is 7 to the output array, we pop 7 since its outta bound, than we go to 9, since 9 is greater than top peek() 6, pop the deque top which is 6 , and deque is empty, so we add 9 to deque, take 9 which is left most and added to output array

        // exmpale [1,1,1,1,1,4,5] k = 6
        // key---->add the index, not numspindex

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove indices that are out of bound
            // say we have deque.peekFirst = 4, we are now in the index i = 9, k = 2, so we need to start with index 9 - 2 + 1 = index 8, so any index > 8, we need to remove it, so need to remvoe 4, 5, 6, 7
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            // if current value greater than top/last one in deque, so we remove previous, until is empty deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // add current value to deque and pop all previous smaller in while loop
            deque.addLast(i);


            // add left most max value to output array
            // take [8,7,6,9] k = 2 as example, say now we in value 7, index i = 1, k =2 , i >= k - 1, we start to add this into output array, i - k + 1 = 0, add deque.peelFirst() which is 8 to ouput array.
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
