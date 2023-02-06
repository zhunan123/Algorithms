package CS545.leetcod.sorting.easy;

public class MinimumSum {
  /**
   * You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2
   * by using the digits found in num. Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
   * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some possible pairs [new1, new2]
   * are [22, 93], [23, 92], [223, 9] and [2, 329].
   * Return the minimum possible sum of new1 and new2.
   *
   * Example 1:
   * Input: num = 2932
   * Output: 52
   * Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
   * The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
   * */

  public int minimumSum(int num) {
    //2932 = num
    //convert number to array of digits
    //[2,9,3,2]
    String nums = Integer.toString(num);
    int[] arr = new int[4];
    for (int i = 0; i < 4;  i++) {
      arr[i] = nums.charAt(i) - '0';
    }

    //bubble sort to sort array
    //[2,2,3,9]
    for (int j = 0; j < arr.length - 1; j++){
      for (int z = arr.length - 1;  z > j; z--) {
        if (arr[z] < arr[z - 1]){
          int temp = arr[z];
          arr[z] = arr[z - 1];
          arr[z - 1] = temp;
        }
      }
    }
    //find smallest sum
    return arr[0] * 10 + arr[2] + arr[1] * 10 + arr[3];
  }
}
