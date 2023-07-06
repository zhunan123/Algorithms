package ShoulderU.Array.july5;

public class BestTimetoBuyandSellStock112 {
  public int maxProfit(int[] prices) {
    // idea: have a min_val set to integer maximum, and a max profit set to 0
    // loop from index 0 to arr end, if prices[i] < min_val set min_val to price[i] (to find the min stock price to buy)
    // else if prices[i] > min_val that where need to sell when price is higher, then we check prices[i] - min_val > maxP ? if yes, update max profit if no says previously we already have the max profit, just continue

    int min_val = Integer.MAX_VALUE;
    int maxP = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min_val) {
        min_val = prices[i];
      } else {
        if (prices[i] - min_val > maxP) {
          maxP = prices[i] - min_val;
        }
      }
    }
    return maxP;
  }
}
