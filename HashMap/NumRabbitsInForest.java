package HashMap;

import java.util.HashMap;
import java.util.Map;

public class NumRabbitsInForest {
    /**
     * 在一个森林中，每个兔子都有一种颜色。兔子中的一部分（也可能是全部）会告诉你有多少兔子和它们有同样的颜色。这些答案被放在了一个数组中。
     * 返回森林中兔子可能的最少的数量。
     *
     * 输入: [1, 1, 2]
     * 输出: 5
     * 解释:
     *   两个回答 "1" 的兔子可能是相同的颜色，姑且说它们为红色.
     *   回答 "2" 的兔子一定不会是红色，不然与前面的答案冲突.
     *   姑且认为回答 "2" 的兔子是蓝色.
     *   那么一定还有 2 只蓝色的兔子在森林里不过没有回答问题.
     *   所以森林里兔子的最少总数是 5, 3只回答问题的加上 2 只没回答的.
     * */

    public int numRabbits(int[] answers) {
        //key是兔子回答的次数，value是这个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        //遍历所有兔子的回答，把数据放入map
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        int rbtNum = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            //每组可以拥有兔子数量= 兔子回答的数字 + 1
            int numPreGroup = e.getKey() + 1;
            //兔子的回答的某个数字的出现次数
            int replyCnt = e.getValue();
            //numOfGroup 代表有多少颜色不同的组
            int numOfGroup = replyCnt / numPreGroup;
            //落单的兔子作为另外一组
            if (replyCnt % numPreGroup != 0) {
                numOfGroup++;
            }
            //计入兔子总数
            rbtNum += numOfGroup * numPreGroup;
        }
        return rbtNum;
    }
}
