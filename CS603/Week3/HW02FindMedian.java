package Week3;

public class HW02FindMedian {

    public static int findMedian(int[] a, int[] b) {
        // a, b is already sorted
        /**
         * My algorithms uses Binary Search to achieve the time complexity of O(logn),
         * my idea is to find a partition line which cross array1 and array2 and separates both lists in 2 sub-list,
         * which all elements in the left sub-list and smaller than any elements in right sub-list.
         * first we define left boundary as 0 and right boundary as length of either array, i is ith element in arr1,
         * as partition line element for arr1, j is jth element in arr2, as partition line element for arr2,
         * if the last element in arr1 left side is smaller than first element in arr2 right side and last element in arr2 left side is smaller than first element in arr1 right side,
         * means we have found the partition, then return median. if last element in arr1 left side is greater than first element in arr2 right side,
         * we move right boundary to i, and if last element in arr2 left side is grater than first element in arr1 right side,
         * we move left boundary to i + 1 then just keep looping until find the satisfied condition.
         * */
        int m = a.length;
        int n = b.length;

        int leftTotal = (m + n) / 2;
        int left = 0;
        int right = m - 1;

        while (left < right) {
            // use binary search find partition line, i is number of element before partition line in arr1
            // say i = 4th element in arr1, and before i the partition line, have 4 element which is ele 0, ele 1, ele 2, ele 3
            int i = left + (right - left) / 2;
            // j is jth element in arr2, and also j is number of element before partition line in arr2, by subtracting i from totalLeft
            int j = leftTotal - i;
            if (a[i - 1] < b[j] && b[j - 1] < a[i]) {
                //a[i] and b[j] is partition line
                left = i;
                right = j;
                break;
            } else if (a[i - 1] > b[j]) {
                //需要寻找的区间在partition line 的左侧
                // move right to left side from position m - 1 to position i
                // if last element in arr1 left side > first element in arr2 right side means too much in left side, so reduce left side element by shrink right to i
                right = i;
            } else {
                // a[i - 1] < b[j] ，要找的就在partition line 右侧，就增加left to i + 1
                left = i + 1;
            }
        }

        // return max of 2 array in both largest in left arr
        return Math.max(a[left - 1], b[right - 1]);
    }
    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{-1, 0, 5, 6, 10}, new int[]{1, 3, 7, 9, 14}));
    }
}
