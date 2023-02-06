package CS545.Week2;

import java.util.Arrays;

public class RecursiveExample1 {

  public static int recursive1(int n) {
    if (n > 1) {
      return 2 * recursive1(n-1);
    }
    else
      return n;
  }

  public static void main(String[] args) {
    int res = recursive1(1);
    System.out.println(res);
  }
}
