package ShoulderU.BFSDFS.june23;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        //每个square都有四条边， 每找到上下左右的island都减去1条边，然后把改正方形的剩下的边加进去final preimeter, 最后return premeter
        //还是先找1，然后找上下左右。看看上下左右找到几个1，4就减去多少，然后把该island的island加到final premeter里
        //然后loop 知道queue empty 就return premeter

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // define res perimeter length
        int res = 0;

        //因为不会有隔层 isolated island的问题，所以我们最开始把第一个island加进去queue然后开始bfs就可以
        outerLoop: for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    break outerLoop;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int originalPerimeter = 4;

            // up
            if (row > 0 && grid[row - 1][col] == 1) {
                if (!visited[row - 1][col]) { // update visited indes
                    visited[row - 1][col] = true;
                    queue.add(new int[]{row - 1, col});
                }
                originalPerimeter--; // have originalPerimeter outside the visted condition, because neither way we need to decrement perimeter if we found a 1
            }
            // down
            if (row < grid.length - 1 && grid[row + 1][col] == 1) {
                if (!visited[row + 1][col]) {
                    visited[row + 1][col] = true;
                    queue.add(new int[]{row + 1, col});
                }
                originalPerimeter--;
            }
            // left
            if (col > 0 && grid[row][col - 1] == 1) {
                if (!visited[row][col - 1]) {
                    visited[row][col - 1] = true;
                    queue.add(new int[]{row, col - 1});
                }
                originalPerimeter--;
            }
            // right
            if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
                if (!visited[row][col + 1]) {
                    visited[row][col + 1] = true;
                    queue.add(new int[]{row, col + 1});
                }
                originalPerimeter--;
            }
            res += originalPerimeter;
        }

        return res;
    }
}
