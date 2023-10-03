package DP;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        // https://www.youtube.com/watch?v=G59JEvLWEfU
        // idea: inialize dp array first row and first column, then iterate thru each point, each pointe
        // should have the min sum, when iteration is done, return last point should be the min sum path

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int j = 1; j < m; j++) {
            grid[j][0] += grid[j - 1][0];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                grid[j][i] += Math.min(grid[j][i - 1], grid[j - 1][i]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
