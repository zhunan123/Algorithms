package ShoulderU.Array.july5;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    // idea is traverse in this order: from beginnging col to end col, from beginning row to end row, from end col to beginning col, from end row to begining row.
    // have a counter keep track beginning row and end row, and begining col and end col, say like after we traverse the beginning row, we are going to increase the boundry row + 1,
    // idea 就是四个方向rowBeginning， rowEnd, colBegining, colEnd 相互操作

    // define res arr
    List<Integer> ans = new ArrayList<>();
    // define edge case
    if (matrix.length == 0){
      return ans;
    }

    // define startRow, startCol, endRow, endCol
    int startRow = 0, endRow = matrix.length - 1;
    int startCol = 0, endCol = matrix[0].length -1;

    // start while loop
    while (startRow <= endRow && startCol <= endCol) {
      // 1->3
      for (int i = startCol; i <= endCol; i++) {
        ans.add(matrix[startRow][i]);
      }
      //increment start row
      startRow++;

      //3->6
      for (int i = startRow; i <= endRow; i++) {
        ans.add(matrix[i][endCol]);
      }
      //decrement endCol
      endCol--;

      //9->7
      if (endRow >= startRow) {
        for (int i = endCol; i >= startCol; i--) {
          ans.add(matrix[endRow][i]);
        }
      }
      //decrement endRow
      endRow--;

      //7->4
      if (endCol >= startCol) {
        for (int i = endRow; i>= startRow; i--) {
          ans.add(matrix[i][startCol]);
        }
      }
      //increment startCol
      startCol++;
    }
    return ans;
  }
}
