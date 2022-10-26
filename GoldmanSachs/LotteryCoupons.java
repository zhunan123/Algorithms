package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

public class LotteryCoupons {

  /**
   *There is a lottery with n coupons and n people take part in it. Each person picks exactly one coupon.
   * Coupons are numbered consecutively from 1 to n, n being the maximum ticket number.
   * The winner of the lottery is any person who owns a coupon where the sum of the digits on the coupon is
   * equal to s. If there are multiple winners, the prize is split equally among them. Determine how many
   * values of s there are where there is at least one winner and the prize is split among most people.
   *
   * Example n = 12 The list of coupon numbers generated from 1 to nis [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12].
   * The sums of the digits are [1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3]. The largest number of winners is 2 which will
   * occur for coupons numbered [1, 10], [2, 11] and [3, 12]. The maximum number of possible winners occurs for
   * any of these 3 possible values of s, so 3 is the answer.
   * */

  public static int lotteryCoupons(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1;i <= n; i++) {
      int tmp = i;
      int sum = 0;
      while(tmp > 0) {
        sum += tmp % 10;
        tmp /= 10;
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    int max = 0;
    for (int key : map.keySet()) {
      max = Math.max(max, map.get(key));
    }
    int res = 0;
    for (int key : map.keySet()) {
      if (map.get(key) == max) {
        res++;
      }
    }
    return res;
  }
}
