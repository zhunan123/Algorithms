package HashMap;

import java.util.HashSet;
import java.util.Set;

public class kDifference {

    /**
     * 有一个整数数组，每个数在数组中都是唯一的。
     * 另有一个整数target，表示目标差值。
     * 你的任务是计算数组中元素对的数量，这些数对的差等于目标差值。
     * 例如：数组[1,3,5]和目标差值2。
     * 有两对数对：[1,3]和[3,5]，它们的差为2。你必须返回一个整数，该整数是差为K的数对数量。
     *
     * 输入: nums = [1, 3, 5, 7], target = 2
     * 输出: 3
     * 解释:
     * 3 - 1 = 2
     * 5 - 3 = 2
     * 7 - 5 = 2
     * */

    public int kDifference(int[] nums, int target) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num - target)) {
                cnt++;
            }
            if (set.contains(num + target)) {
                cnt++;
            }
            set.add(num);
        }
        return cnt;
    }
}
