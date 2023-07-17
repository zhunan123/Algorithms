package ShoulderU.Array.july14;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency451 {
  public String frequencySort(String s) {
    //先把每个字符串驾到map里
    //创立maxheap根据map的frequency 自己写comparactor
    //然后把字符串都加到maxheap里
    //最后在吧heap里面的东西倒出来放到final str
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
      int compareFreq = map.get(b) - map.get(a);
      if (compareFreq == 0) {
        return a.compareTo(b);
      }
      return compareFreq;
    });

    for (int i = 0; i < s.length(); i++) {
      maxHeap.add(s.charAt(i));
    }

    String res = "";
    while (!maxHeap.isEmpty()) {
      res += maxHeap.poll();
    }

    return res;
  }
}
