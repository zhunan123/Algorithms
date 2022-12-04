package Sorting;

public class KthLargestElementUsingQuickSort {
    /**
     * 在数组中找到第 k 大的元素。
     * 输入：
     * k = 1
     * nums = [1,3,4,2]
     * 输出：
     * 4
     *
     * 算法：快速选择算法
     * 最容易想到的就是直接排序，返回第k大的值。时间复杂度是O(nlogn)，这里提供O(n)的解法。
     * 这题其实是快速排序算法的变体，通过快速排序算法的partition步骤，可以将小于pivot的值划分到pivot左边，
     * 大于pivot的值划分到pivot右边，所以可以直接得到pivot的rank。从而缩小范围继续找第k大的值。
     * partition步骤：
     * 令left = start，right = end，pivot = nums[left]。
     * 当nums[left] < pivot时，left指针向右移动。
     * 当nums[right] > pivot时，right指针向左移动。
     * 交换两个位置的值，right指针左移，left指针右移。
     * 直到两指针相遇，否则回到第2步。
     * 每次partition后根据pivot的位置，寻找下一个搜索的范围。
     * */

    public int kthLargestElement(int k, int[] nums) {
        int n = nums.length;
        // 为了方便编写代码，这里将第 k 大转换成第 k 小问题。
        k = n - k;
        return partition(nums, 0, n - 1, k);
    }
    public int partition(int[] nums, int start, int end, int k) {
        int left = start, right = end;
        int pivot = nums[left];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        // 如果第 k 小在右侧，搜索右边的范围，否则搜索左侧。
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
