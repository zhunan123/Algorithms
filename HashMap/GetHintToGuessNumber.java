package HashMap;

public class GetHintToGuessNumber {
    /**
     * 你正在和你的朋友玩 猜数字 (Bulls and Cows)游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，
     * 告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
     * 你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     *
     * 输入：secret = "1807", guess = "7810"
     * 输出："1A3B"
     * 解释：1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     *
     * 根据题意，对于公牛，需要满足数字和确切位置都猜对。我们可以遍历 secret 和 guess，统计满足 secret[i]=guess[i]secret[i]=guess[i] 的下标个数，即为公牛的个数。
     *
     * 对于奶牛，需要满足数字猜对但是位置不对。我们可以在 secret[i]
     * 不等于
     * guess[i] 时，分别统计 secret 和 guess 的各个字符的出现次数，记在两个长度为 1010 的数组中。
     * 根据题目所述的「这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字」，由于多余的数字无法匹配，对于 0 到 9 的每位数字，
     * 应取其在 secret 和 guess 中的出现次数的最小值。将每位数字出现次数的最小值累加，即为奶牛的个数。
     * */

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
