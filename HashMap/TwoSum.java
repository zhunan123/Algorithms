package HashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
     * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
     * 输入：
     * numbers = [2,7,11,15]
     * target = 9
     * 输出：
     * [0,1]
     * */

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashtable.containsKey(target - numbers[i])) {
                return new int[]{hashtable.get(target - numbers[i]), i};
            }
            hashtable.put(numbers[i], i);
        }
        return new int[0];
    }
}
