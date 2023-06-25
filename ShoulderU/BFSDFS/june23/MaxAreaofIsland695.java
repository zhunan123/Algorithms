package ShoulderU.BFSDFS.june23;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        // 创立queue，找到1加进queue，poll queue，加上下左右四个方向的room(如果是1的话才用加进去queue)，直到queue empty， 然后就是说明该island已经被0包围了，同时keep track 该island的area 就每个island+1， 最后更新max island，
        //然后就是继续重复复找1，然后每次都比较 max island， 更新max，最后return max island

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currentArea = 0;
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];
                    // update currentArea
                    currentArea++;
                    // up
                    if (row > 0 && grid[row - 1][col] == 1 && !visited[row - 1][col]) {
                        visited[row - 1][col] = true;
                        // add upper room into queu
                        queue.add(new int[]{row - 1, col});
                    }
                    // down
                    if (row < grid.length - 1 && grid[row + 1][col] == 1 && !visited[row + 1][col]){
                        // update upper room visited
                        visited[row + 1][col] = true;
                        // add upper room into queu
                        queue.add(new int[]{row + 1, col});
                    }
                    // left
                    if (col > 0 && grid[row][col - 1] == 1 && !visited[row][col - 1]){
                        // update upper room visited
                        visited[row][col - 1] = true;
                        // add upper room into queu
                        queue.add(new int[]{row, col - 1});
                    }
                    //right
                    if (col < grid[0].length - 1 && grid[row][col + 1] == 1 && !visited[row][col + 1]){
                        // update upper room visited
                        visited[row][col + 1] = true;
                        // add upper room into queue
                        queue.add(new int[]{row, col + 1});
                    }
                }

                // update maxArea
                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }

        // return maxArea
        return maxArea;
    }
}
