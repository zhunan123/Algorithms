package HashMap;

import java.util.HashSet;

public class RemoveDuplication {

    /**
     * 给一个整数数组 nums，在逻辑上去除重复的元素，返回去除后的数组长度 n，使得通过去重操作数组 nums 的前 n 个元素中，
     * 包含原数组 nums 去重后的所有元素。
     * 你应该做这些事
     * 1.在原数组上操作
     * 2.将去除重复之后的元素放在数组的开头
     * 3.返回去除重复元素之后的元素个数
     *
     *
     * 输入数据
     * [1,3,1,4,4,2]
     * 输出数据
     * [1,3,4,2,4,2]
     * 4
     *
     * 1. 将重复的整数移动到 nums 的尾部 => nums = [1,3,4,2,?,?].
     * 2. 返回 nums 中唯一整数的数量  => 4.
     * 事实上我们并不关心你把什么放在了 ? 处, 只关心没有重复整数的部分
     * */

    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[len++] = nums[i];
            }
        }

        return len;
    }
}
