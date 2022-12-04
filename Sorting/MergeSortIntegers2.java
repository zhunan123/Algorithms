package Sorting;

public class MergeSortIntegers2 {

    /**
     * 给一组整数，请将其在原地按照升序排序。使用归并排序，快速排序，堆排序或者任何其他 O(n log n) 的排序算法。
     * 例1：
     *
     * 输入：[3,2,1,4,5]，
     * 输出：[1,2,3,4,5]。
     * 例2：
     *
     * 输入：[2,3,1]，
     * 输出：[1,2,3]。
     * */
    int[] tmp;
    public int[] sortIntegers2(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}
