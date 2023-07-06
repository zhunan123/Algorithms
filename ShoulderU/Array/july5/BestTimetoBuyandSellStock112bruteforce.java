package ShoulderU.Array.july5;

public class BestTimetoBuyandSellStock112bruteforce {
  public int maxProfit(int[] prices) {
    // idea: define a max profit, have 2 for loop, first for loop from first index, second from the index after the first index, calcuate and update the maxprofit

    int maxP = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxP) {
          maxP = profit;
        }
      }
    }
    return maxP;
  }
}
