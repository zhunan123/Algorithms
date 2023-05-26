package ShoulderU.Array.May24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // create ans list
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        // loop from first element
        for (int i = 0; i < nums.length - 3; i++) {
            //this is the smallest possiblity since array is sorted, no combonation will be smaller
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // we want unique, so remove duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // loop from second element
            for (int j = i + 1; j < nums.length - 2; j++) {
                // this is smallest possiblty for fixed i and j
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // remove duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // here start the normal 2 sum with 2 pointer
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int currentSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (currentSum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // remove duplicates
                        while (left < right && (nums[left] == nums[left + 1])) {
                            left++;
                        }

                        while ((left < right) && (nums[right] == nums[right - 1])) {
                            right--;
                        }

                        // advance pointer
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
