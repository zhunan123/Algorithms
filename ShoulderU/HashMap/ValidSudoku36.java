package ShoulderU.HashMap;

import java.util.HashSet;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        // 判断每一行，每一列，每一个内部小方格有没有重复, 用hashset里面加入string来判断，set.add() if not already in set will return true, if is already in set will return false;

        //just need to loop every single element in this sudoku, for each current_val check if its alreay in its row, col or box. and check if dup in each row, col, or box
        // set contains string and board[][] is contains string so we just use addition
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current_val = board[i][j];
                if (current_val != '.') {
                    // if current value already in this row or already in this col or already in this box return false
                    //set.add() if not already in set will return true, if is already in set will return false
                    if (!set.add(current_val + "found in row " + i) || !set.add(current_val + "found in col " + j)
                        || !set.add(current_val + "found in box " + i / 3 + "," + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
