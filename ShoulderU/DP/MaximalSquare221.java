package DP;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        // 當前點能夠組成正方形的數量就是，左邊點，右邊點，左邊斜上方點，三個點取最小值+ 1
        // 然後從頭便利一個一個便利每一個elemnt，找到最大值，然後return就行
        // https://www.youtube.com/watch?v=grfZlZT03mM
        // dp[][] has one more 0's before the first row and first colume for better culculateion so dp[i][j] is actually matrix[i - 1][j - 1]

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') { // this is search on matrix on 1 and 0, if is current point is 1 means at least the error is 1, but need to check in dp for actual value.
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i <= m; i++) { // need to make sure i <= m since we adding one more col and rol before matrix
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1'){ // at least 1 for erea since its self is a square
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
