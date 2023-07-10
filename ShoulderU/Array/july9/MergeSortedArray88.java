package ShoulderU.Array.july9;

public class MergeSortedArray88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // compare the index of nums1 and nums1, which one is smaller add to res array,
    // i is the index of nums1, j ins the index of nums2, k is the index of result int[], them map res into nums1
    // create res int[]
    int[] res = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (k < m + n) {
      // edge case 1
      if (i >= m) { // this need to consider = in this case
        res[k] = nums2[j];
        j++;
        k++;
      } else if (j >= n) { //edge case2
        res[k] = nums1[i];
        i++;
        k++;
      } else {
        // general case
        if (nums1[i] <= nums2[j]) {
          res[k] = nums1[i];
          i++;
          k++;
        } else {
          res[k] = nums2[j];
          j++;
          k++;
        }
      }
    }

    for (int v = 0; v < res.length; v++) {
      nums1[v] = res[v];
    }
  }
}
