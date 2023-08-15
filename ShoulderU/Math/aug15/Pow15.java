package ShoulderU.Math.aug15;

public class Pow15 {
  public double myPow(double x, int n) {
    // define isNegative, if n < 0 change x and n
    // while loop n是基数的话，贴到ans上就结算temp，如果是偶数，就temp^2,  n / 2
    // 如果negative是true， ans还要在乘以x，因为之前把它剪掉了
    // 2 ^ 3, 2 ^ -3
    boolean isNegative = false;
    if (n < 0) {
      isNegative = true;
      x = 1 / x;
      // 如果n是-2^31， 变成正的就越界了，所以加1，然后这里剪了一次乘以x，后面要补上
      n = - (n + 1);
    }

    double ans = 1;
    double temp = x;

    while (n != 0) {
      if (n % 2 == 1){
        ans *= temp;
      }
      temp *= temp;
      n /= 2;
    }

    if (isNegative) {
      ans *= x;
    }
    return ans;
  }
}
