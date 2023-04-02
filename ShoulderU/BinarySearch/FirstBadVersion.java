package ShoulderU.BinarySearch;

public class FirstBadVersion {

    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     *
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     *
     * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 5, bad = 4
     * Output: 4
     * Explanation:
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version.
     * */

    public int firstBadVersion(int n) {

        //find the first bad version with first_pos, idea if we found the target(isBadVersion(mid), then we know the
        //first target is in the left. update first_pos to mid, and update high to mid -1, else is not bad version
        //then we know the target is in the right side of mid
        int low = 1;
        int high = n;
        int first_pos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                //if find, the first bad should be on the left
                high = mid - 1;
                first_pos = mid;
            } else {
                //did not find the first bad, so the first bad should on the right
                low = mid + 1;
            }
        }
        return first_pos;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
