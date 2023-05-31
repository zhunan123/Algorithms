package ShoulderU.Array.May27;

import java.util.Arrays;

public class MinimizeProductSumofTwoArrays1874 {
    /**
     * in order to find the minimum product sum of 2 array,
     * sort the first array in ascending order and second array in descending/reverser increasding order,
     * then take the product sum of each element, will find the minimum sum
     * */
    public int minProductSum(int[] nums1, int[] nums2) {
        // sort 2 array
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // initilize sum
        int sum = 0;

        // initilize pointer i for nums1; pointer j for nums2 which start from the end of nums2 in reversing order
        int i = 0;
        int j = nums2.length - 1;

        while (i < nums1.length) {
            sum += nums1[i] * nums2[j];
            i++;
            j--;
        }
        return sum;
    }
}
