package CS603;

import java.util.HashSet;
import java.util.List;

public class WordBreak139 {
  // DP
  public boolean wordBreak(String s, List<String> wordDict) {
      // s = "lowKey" wirdDict=["low", "key"]
      // https://www.youtube.com/watch?v=H2EgWq-45CY
      // previous result is updated true false in dp[] and next result is depends on this result

      HashSet<String> set = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;

      for (int i = 1; i <= s.length(); i++) {
          for (int j = 0; j < i; j++) {
              if (dp[j] && set.contains(s.substring(j, i))) {
                  dp[i] = true;
                  break;
              }
          }
      }

      return dp[s.length()];
  }
}
