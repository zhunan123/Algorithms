package CS545.week9.LeetCode;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * You must solve it in O(n) time complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     * */

    /**
     * use max heap, theta is n*log(k) since only need kth largest element,
     * time complexity is smaller than logn
     * */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
        }

        int i = 0;
        int deleted = 0;
        while (i < k) {
            deleted = maxheap.poll();
            i++;
        }
        return deleted;
    }
}
