package ShoulderU.BFSDFS.june22;

import java.util.LinkedList;
import java.util.Queue;

public class FloorFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 还是创建queue，先把initial (sr, sc) 加进来，poll 完之后把该颜色变成target color，把上下左右是相同prev color的都加进来，如果不一样的就不变
        // 使用BFS来完成
        // if is already visited do not add duplicate to queue again
        Queue<int[]> queue = new LinkedList<>();
        // add initial point
        queue.add(new int[]{sr, sc});
        // create boolean[][] visited 2-D array to check if grid is being visited, initially with all false in the 2-D array
        boolean[][] visited = new boolean[image.length][image[0].length];
        // start the while loop
        // the thing is there need to avoid duplicatese I think
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            // upper
            if (row > 0 && image[row - 1][col] == image[row][col] && !visited[row - 1][col]) {
                visited[row - 1][col] = true;
                queue.add(new int[]{row - 1, col});
            }
            // lower
            if (row < image.length - 1 && image[row + 1][col] == image[row][col] && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                queue.add(new int[]{row + 1, col});
            }
            // left
            if (col > 0 && image[row][col - 1] == image[row][col] && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                queue.add(new int[]{row, col - 1});
            }
            // right
            if (col < image[0].length - 1 && image[row][col + 1] == image[row][col] && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                queue.add(new int[]{row, col + 1});
            }

            // update current square val
            image[row][col] = color;
        }
        //return image
        return image;
    }
}
