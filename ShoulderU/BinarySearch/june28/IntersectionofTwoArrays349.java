package ShoulderU.BinarySearch.june28;

import java.util.HashSet;

public class IntersectionofTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            if (containsNum(nums2, num)) {
                set.add(num);
            }
        }

        // create ans int[] with set size
        int[] ans = new int[set.size()];
        int index = 0;
        for (int ele : set) {
            ans[index] = ele;
            index++;
        }
        return ans;
    }

    public boolean containsNum(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
