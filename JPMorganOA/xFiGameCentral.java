package JPMorganOA;

//https://leetcode.com/discuss/interview-question/860183/xfi-game-central-problem-oa-comcast
/**
 * 第一题，wendy和bob玩游戏，给定字符串只包含bw，例如bbbbwwww，
 * 三个连在一起的相同字符可以消去中间一个，wendy先动，
 * 消w，bob后动，消b，谁先无法操作谁输。问最后谁胜。
 * 例如wwwwbbb消去w变成wwwbbb，消去b变成wwwbb，消去w变成wwbb，无法再消，所以wendy胜
 */

class xFiGameCentral {
    public String gameWinner(String colors) {
        int wendy = 0;
        int bob = 0;
        char[] c = colors.toCharArray();
        for (int i = 1; i < c.length - 1; i++) {
            if(c[i-1] == 'w' && c[i] == 'w' && c[i+1] == 'w') {
                wendy++;
            }
            if(c[i-1] == 'b' && c[i] == 'b' && c[i+1] == 'b'){
                bob++;
            }
        }
        return wendy > bob ? "wendy" : "bob";
    }
}
