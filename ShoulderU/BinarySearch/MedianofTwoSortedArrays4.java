package BinarySearch;

public class MedianofTwoSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // want to search based on smaller array, default assume nums1 has a smaller length
        if (nums1.length > nums2.length) {
            return helper(nums2, nums1);
        }
        return helper(nums1, nums2);
    }

    private double helper(int[] nums1, int[] nums2) {
        int left = 0, right = nums1.length; // need to make right as smaller array length
        int totalLeft = (nums1.length + nums2.length + 1) / 2;

        double ans = 0;

        while (left <= right) {
            int partitionNums1 = left + (right - left) / 2; // mid
            int partitionNums2 = totalLeft - partitionNums1; // left remaining in nums2

            // define max value and min val before and after partition in both nums1 and nums2, need to take care if go outter bound case
            int maxNums1Left = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int maxNums1Right = (partitionNums1 == nums1.length) ? Integer.MAX_VALUE : nums1[partitionNums1];
            int maxNums2Left = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int maxNums2Right = (partitionNums2 == nums2.length) ? Integer.MAX_VALUE : nums2[partitionNums2];


            if (maxNums1Left < maxNums2Right && maxNums2Left < maxNums1Right) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    ans = (double)(Math.max(maxNums1Left, maxNums2Left) + Math.min(maxNums1Right, maxNums2Right)) / 2;
                } else {
                    ans = (double)(Math.max(maxNums1Left, maxNums2Left));
                }
                break;
            }

            if (maxNums1Left > maxNums2Right) {
                right = partitionNums1;
            } else {
                left = partitionNums1 + 1;
            }
        }

        return ans;
    }
}
