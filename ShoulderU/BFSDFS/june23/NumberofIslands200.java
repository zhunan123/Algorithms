package ShoulderU.BFSDFS.june23;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        // 写两个for loop， loop里面是while loop，loop all 2-D elements，同时更新visited，从第一个开始，把1加进来，poll queue (然后mark这个1为visited)，然后把上下左右的1都加进来queue，直到queue empty 就是一个isolated island
        // 然后去寻找下一个1而确实没有mark visited的，加入queue，然后重新开始上一轮的操作
        // only increment the number if we find a 1, otherwise not a island so dont add

        //handle edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // define number of islands
        int numberOfIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // only add to queue if is 1 and not visited
                if (!visited[i][j] && grid[i][j] == '1') {
                    //update visited and add current to queue
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    // increment number of island,
                    // only increment the number if we find a 1, otherwise not a island so dont add
                    numberOfIsland++;
                }


                // start while loop
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];

                    // up, need to check if the upper room has value of 1 and also not being visited yet
                    if (row > 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]){
                        // update upper room visited
                        visited[row - 1][col] = true;
                        // add upper room into queu
                        queue.add(new int[]{row - 1, col});
                    }
                    // down
                    if (row < grid.length - 1 && grid[row + 1][col] == '1' && !visited[row + 1][col]){
                        // update upper room visited
                        visited[row + 1][col] = true;
                        // add upper room into queu
                        queue.add(new int[]{row + 1, col});
                    }
                    // left
                    if (col > 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]){
                        // update upper room visited
                        visited[row][col - 1] = true;
                        // add upper room into queu
                        queue.add(new int[]{row, col - 1});
                    }
                    //right
                    if (col < grid[0].length - 1 && grid[row][col + 1] == '1' && !visited[row][col + 1]){
                        // update upper room visited
                        visited[row][col + 1] = true;
                        // add upper room into queue
                        queue.add(new int[]{row, col + 1});
                    }
                }
            }
        }

        //return final number of island
        return numberOfIsland;
    }
}
