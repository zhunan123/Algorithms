package ShoulderU.BFSDFS.june22;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate286 {
    /**
     * 题目意思就是在每个空的地方fill到最近的gate的距离， 要做的就是假设以每一个gate作为中心，以水滴的方式泛起涟漪一圈一圈，
     * (就是先把每个涟漪的中心pop出来，然后把涟漪的上下左右作为child都加进来，同时更新上下左右的value也就是到gate的距离)
     * 先把所有的gate加进queue，然后分上下左右，然后把上下左右的格子都加到queue里进行bfs，如果上下左右任意一个如果是infinity的话，
     * 然后他到gate的距离其实就是当前空格的个数加1，空格个数有可能是1，2，3-----
     * 首先edge case 如果roomes length是0的话 就直接return
     * 创立queue(queue 里面是每一个空格的坐标，也就是int[] pair,里面是该空格的row col坐标)，遍历room里的每一个，先是横排，再是纵排，如果找到gate的话就加到queue里面
     * while queue not empty开始loop，做一个queue poll，然后定义当前空格的row 和 col
     * 分上下左右
     *  - 上：如果row > 0 和当前格子的上一个是infinity，那就是上格子 = 当年格子的数字+ 1， 把上格子加入queue（就相当于把child加进去）
     *  - 下：如果row < row.length - 1;, 当前格子的下一个是infinity，那就是下格子 = 当前格子的数字+ 1， 把下格子加入queue（就相当于把child加进去）
     *  - 左：
     *  - 右：
     *  就相当于pop掉一个格子，把以这个格子为中心的上下左右格子都加进queue，然后同时更新每一个格子的数字根据parent格子，数字也就是当前格子到最近的gate的距离
     * */

    public void wallsAndGates(int[][] rooms) {
        // create queue
        Queue<int[]> queue = new LinkedList<>();
        // edge case
        if (rooms.length == 0) {
            return;
        }

        // initially add all gate into queue
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // start while loop and start with the gate
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // current row
            int row = current[0];
            // current col
            int col = current[1];
            // up if upper room is empty place, update upper room distance(current room + 1) to gate and add to queue
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            // down
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            // left
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            // right
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
