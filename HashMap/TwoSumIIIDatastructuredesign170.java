package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIIIDatastructuredesign170 {
  List<Integer> list;
  Map<Integer, Integer> map;
  public TwoSumIIIDatastructuredesign170() {
    list = new ArrayList<>();
    map = new HashMap<>();
  }

  public void add(int number) {
    list.add(number);
    map.put(number, map.getOrDefault(number, 0) + 1);
  }

  public boolean find(int value) {
    for (int num : list) {
      int remaining = value - num;
      if (map.containsKey(remaining)) {
        if (remaining != num) {
          return true;
        } else if (map.get(remaining) > 1) {
          return true;
        } else {
          continue;
        }
      }
    }
    return false;
  }
}
