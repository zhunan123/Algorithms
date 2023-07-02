package ShoulderU.BinarySearch.july1;

public class Searcha2DMatrix74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    // idea make the 2d array same as 1d array just need to handle the midpoint pivot element to match the 2D array
    // just mid pivot is 11, index is 5, so we have matrix[row][col] = matrix[1][1] = matrix[midIndex/col][midIndex%col]

    // define edge case
    if (matrix.length == 0) {
      return false;
    }

    // define row & col
    int row = matrix.length;
    int col = matrix[0].length;

    // define low high
    int low = 0, high = row * col - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      // need to find the midElement using matrix 2d way
      int midElement = matrix[mid / col][mid % col];
      if (midElement == target) {
        return true;
      }
      if (midElement > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}
