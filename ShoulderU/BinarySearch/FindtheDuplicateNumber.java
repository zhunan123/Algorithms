package ShoulderU.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class FindtheDuplicateNumber {

    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     * */

    /**
     * if count element before mid point,
     * if count < mid index means theres duplicate in the left half,
     * else duplicate in the right half
     * */

    public int FindDuplicate(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            for (int i = 0; i < mid; i++) {
//                if(map.containsKey(nums[i])) {
//                    map.put(nums[i], map.get(nums[i]) + 1);
//                } else {
//                    map.put(nums[i], 1);
//                }
//            }
//
//            int count = map.size();
//            if (count < mid) {
//                right = mid -1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return nums[right];


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == 2) {
                return set.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber find = new FindtheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        int num = find.FindDuplicate(nums);
        System.out.println(num);
    }
}
