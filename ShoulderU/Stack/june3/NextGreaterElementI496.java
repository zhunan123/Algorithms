package ShoulderU.Stack.june3;

public class NextGreaterElementI496 {

  /**
   * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
   * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
   * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
   * If there is no next greater element, then the answer for this query is -1.
   * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
   * */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // brute force
    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (nums2[j] == nums1[i]) {
          int currIndex = j;
          while (currIndex < nums2.length) {
            if ((currIndex + 1 < nums2.length) && (nums2[currIndex + 1] > nums2[j])) { // here need to compare with nums2[j]
              res[i] = nums2[currIndex + 1];
              break;
            }
            currIndex++;
          }
          if (res[i] == 0) {
            res[i] = -1;
          }
          break;
        }
      }
    }
    return res;
  }
}
