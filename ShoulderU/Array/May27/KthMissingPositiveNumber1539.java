package ShoulderU.Array.May27;

public class KthMissingPositiveNumber1539 {
    // case 1: [3, 4, 5], k = 2, result = 2
    // case 2: [3, 4, 5, 9], k = 3, result = 6
    // case 3: [1, 2, 3], k = 2, result = 5
    public int findKthPositive(int[] arr, int k) {
        int missedInt = 0; //initilize the count how many missed integer
        for (int i = 0; i < arr.length; i++) {
            // case 1 missing all kth number before the first element
            if (i == 0) {
                missedInt += arr[0] - 1; // count missed integer that before the first element
                if (missedInt >= k) {
                    return k;
                }
            } else {
                // second condition missing the kth element within the nums array range
                missedInt += arr[i] - arr[i - 1] - 1; // if arr[i] = 4, arr[i - 1] = 3, arr[i] - arr[i  - 1] - 1 = 0, means no missed int, but if arr[i] = 9, arr[i - 1] = 5, arr[i] - arr[i  - 1] - 1 = 3, means 3 missing integer, which is 6, 7, 8, so added 3 to the missed intger count;
                if (missedInt >= k) {
                    // need to then go back to previous missedint
                    missedInt -= arr[i] - arr[i - 1] - 1;
                    // find the kth missing element
                    int result = arr[i - 1]; //having result starting from the element before current position
                    while (missedInt < k) {
                        result++;
                        missedInt++;
                    }
                    return result;
                }
            }
        }

        // case 3 missing the kth element after the last elements in the nums array.
        int result = arr[arr.length - 1];
        while (missedInt < k) {
            result++;
            missedInt++;
        }
        return result;
    }
}
