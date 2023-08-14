package ShoulderU.Math.aug13;

public class DivideTwoIntegers29 {
  public int divide(int dividend, int divisor) {
    // https://www.youtube.com/watch?v=XKuFGEGt5zo&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    // ^ this is bitwise xor, only different signal is true, same signal is false, convert to long,
    // << 1 就是bitwise往左移一位，就是 * 2^1
    // 19 / 3 = 6
    // << is just multiple by 2 but dont change number just 3 * 2, but <<= 2 is actually update number to 3 * 2

    //判断signal
    int sig = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    //define long
    long divi_long = Math.abs((long) dividend);
    long divs_long = Math.abs((long) divisor);
    //define res
    long res = 0;
    //start while loop
    while (divs_long <= divi_long) {
      long temp = divs_long;
      long mul = 1;
      // << not updateing the number
      while (temp << 1 <= divi_long) {
        // <<= is updateing the number
        temp <<= 1;
        mul <<= 1;
      }
      res += mul;
      divi_long = divi_long - temp;
    }
    // multiple by sig
    res *= sig;
    //if > max_val is max value other is (int) res cast it back
    if (res >= Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else {
      return (int) res;
    }
  }
}
