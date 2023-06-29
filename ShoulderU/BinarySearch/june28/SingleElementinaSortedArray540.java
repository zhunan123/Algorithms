package ShoulderU.BinarySearch.june28;

public class SingleElementinaSortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        // before we encounter single element we have duplicate pair first one is even index, second one is odd index
        // after we encounter a single element, the duplicate pair will start in odd index and second is even index
        // idea is find the mid elment,  if nums[mid - 1] != nums[mid] != nums[mid + 1] return mid
        // if (mid index = odd && nums[mid - 1] = nums[mid]) || (mid index = even && nums[mid] = nums[mid + 1]), 说明single在后面，low = mid + 1
        // else 说明在前面，也就是(mid index = even && && nums[mid - 1] = nums[mid] || mid index = odd && nums[mid] = nums[mid + 1])就是high =  mid - 1
        // 1, 1, 2, 2, 3, 4, 4, before single 3 is found, we have 1, 1 & 2, 2 in first even index, second odd index pair, after discover single 3, we have 4,4 first 4 index odd, and second 4 even index

        int low = 0, high = nums.length - 1;

        // boundary check
        if (high == 0) { // if there's only 1 int in the nums like [1]
            return nums[high];
        } else if (nums[0] != nums[1]) { // if the first element is the unique element
            return nums[0];
        } else if (nums[nums.length - 1] != nums[nums.length - 2]) { //if the last element is the unique element
            return nums[nums.length - 1];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
