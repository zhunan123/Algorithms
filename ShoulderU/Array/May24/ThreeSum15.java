package ShoulderU.Array.May24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // create ans list
        List<List<Integer>> ansList = new ArrayList<>();

        // iterate the array and use 2 sum
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            // remove duplicates when iterating the nums array
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            while (left < right) {
                List<Integer> innerList = new ArrayList<>(); // innerlist is the list that contains the elements
                if (nums[left] + nums[right] == target) { // check if nums[left] + nums[right] equals the remaining sum
                    // add to innerlist
                    innerList.add(nums[i]);
                    innerList.add(nums[left]);
                    innerList.add(nums[right]);
                    // add to ansList
                    ansList.add(innerList);

                    // advance the pointer
                    left++;
                    right--;

                    // remove duplicates, when finding inwards left and right pointer, advance the pointer if we found same left pointer or right pointer.
                    while((left < right) && (nums[left] == nums[left - 1])) {
                        left++;
                    }
                    while ((left < right) && (nums[right] == nums[right + 1])) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ansList;
    }
}
