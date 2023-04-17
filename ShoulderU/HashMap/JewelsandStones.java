package ShoulderU.HashMap;

import java.util.HashMap;

public class JewelsandStones {

  /**
   * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
   *
   * Letters are case sensitive, so "a" is considered a different type of stone from "A".
   *
   *
   *
   * Example 1:
   *
   * Input: jewels = "aA", stones = "aAAbbbb"
   * Output: 3
   * */

  public int numJewelsInStones(String jewels, String stones) {
    HashMap<String, Integer> map = new HashMap<>();

    String[] jewelsArr = jewels.split("");
    for (int i = 0; i < jewelsArr.length; i++) {
      if (map.containsKey(jewelsArr[i])) {
        int val =  map.get(jewelsArr[i]);
        val++;
      } else {
        map.put(jewelsArr[i], 1);
      }
    }

    int count = 0;
    String[] stonesArr = stones.split("");
    for (int j = 0; j < stonesArr.length; j++) {
      if (map.containsKey(stonesArr[j])) {
        count++;
      }
    }

    return count;
  }
}
