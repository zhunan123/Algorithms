package ShoulderU.Array.july30;

public class RotateImage48 {
  public void rotate(int[][] matrix) {
    // idea: 旋转90度，上下互换，90度斜角度互换,需要两个loop，（only换上半区的2，3，6--->2根4，3跟7，6和8互换）2就是matrix[0][1], 跟matrix[1][0]
    // 上下互换
    int top = 0, bot = matrix.length - 1;
    while (top < bot) {
      int[] temp = matrix[top];
      matrix[top] = matrix[bot];
      matrix[bot] = temp;

      top++;
      bot--;
    }

    // 斜角90度互换
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix[i].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
