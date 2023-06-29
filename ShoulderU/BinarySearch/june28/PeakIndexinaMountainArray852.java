package ShoulderU.BinarySearch.june28;

public class PeakIndexinaMountainArray852 {
    public int peakIndexInMountainArray(int[] arr) {
        // idea is doing O()logn) binary seach
        // so we have low from index 0, and have high as arr.length - 1
        // and we have mid as low + (high - low) / 2
        // if (arr[mid] > arr[mid + 1]) then we know ans is between low < ans <= mid, so we place high = mid
        // if (arr[mid] < arr[mid + 1]) then we know ans is between mid < ans < high. we place low as mid + 1
        // if low = high, we have find our index ans

        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            if (low == high) {
                ans = high;
                break;
            }
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
