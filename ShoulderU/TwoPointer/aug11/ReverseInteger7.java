package ShoulderU.TwoPointer.aug11;

public class ReverseInteger7 {
  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int remaining = x % 10;
      int newRes = result * 10 + remaining;
      //判断是否越界
      if (newRes / 10 != result) {
        return 0;
      }
      result = newRes;
      x /= 10;
    }
    return result;
  }
}
