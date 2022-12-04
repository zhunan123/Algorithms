package Sorting;

public class PartitionArray {
    /**
     * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
     * 所有小于k的元素移到左边
     * 所有大于等于k的元素移到右边
     * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
     * 输入：
     * nums = [3,2,2,1]
     * k = 2
     * 输出：
     * 1
     *
     * 设置一个offset值，每次将 <k 的值与offset位置上的值交换位置，然后offset++。因为不需要担心顺序，
     * 所以可以无论exchange的数是否小于k，最后所有左边的数都会小于k
     * */

    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                int temp = nums[i];
                nums[i] = nums[offset];
                nums[offset] = temp;
                offset ++;
            }
        }

        return offset;
    }
}
