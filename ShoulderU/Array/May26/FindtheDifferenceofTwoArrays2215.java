package ShoulderU.Array.May26;

import java.util.ArrayList;
import java.util.List;

public class FindtheDifferenceofTwoArrays2215 {
    public boolean checkExist(int num, int[] nums) {
        for (int number : nums) {
            if (number == num) {
                return true;
            }
        }
        return false;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        // create ans array
        List<List<Integer>> ans = new ArrayList<>();

        // create list of all unique integers in nums1 that not in nums2
        List<Integer> uniqNums1 = new ArrayList<>();

        // create list of all unique integers in nums2 that not in nums1
        List<Integer> uniqNums2 = new ArrayList<>();

        // loop nums1 check if nums2 contains any of it
        for (int i = 0; i < nums1.length; i++) {
            if (!checkExist(nums1[i], nums2)) {
                // check if already existed
                if (!uniqNums1.contains(nums1[i])) {
                    uniqNums1.add(nums1[i]);
                }
            }
        }
        ans.add(uniqNums1);

        // loop nums2 check if nums1 contains any of it
        for (int i = 0; i < nums2.length; i++) {
            if (!checkExist(nums2[i], nums1)) {
                // check if already existed
                if (!uniqNums2.contains(nums2[i])) {
                    uniqNums2.add(nums2[i]);
                }
            }
        }
        ans.add(uniqNums2);

        return ans;
    }
}
