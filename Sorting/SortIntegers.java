package Sorting;

public class SortIntegers {
    /**
     * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
     * 样例  1:
     * 	输入:  [3, 2, 1, 4, 5]
     * 	输出:  [1, 2, 3, 4, 5]
     * 	样例解释:
     * 	返回排序后的数组。

     * 样例 2:
     * 	输入:  [1, 1, 2, 1, 1]
     * 	输出:  [1, 1, 1, 1, 2]
     * 	样例解释:
     * 	返回排好序的数组。
     *
     * 	冒泡排序
     * 基本思想：外层循环每一次经过两两比较，把每一轮未排定部分最大的元素放到了数组的末尾；
     * 「冒泡排序」有个特点：在遍历的过程中，提前检测到数组是有序的，从而结束排序，而不像「选择排序」那样，即使输入数据是有序的，
     * 「选择排序」依然需要「傻乎乎」地走完所有的流程。
     * */

    public int[] sortIntegers(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
