package ShoulderU.BinarySearch.july1;

public class FirstBadVersion278 {
  public int firstBadVersion(int n) {
    int low = 0, high = n;
    int mid = 0;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (!isBadVersion(mid - 1) && isBadVersion(mid)) {
        break;
      }
      if (isBadVersion(mid)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return mid;
  }

  private boolean isBadVersion(int mid) {
    return false;
  }
}
