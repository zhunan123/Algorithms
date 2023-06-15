package ShoulderU.QueueMinHeap.june14;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767 {
  public String reorganizeString(String s) {
    // map the string each char
    Map<Character, Integer> map = new HashMap<>();

    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // create priorityqueue and add char to pq
    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

    // add to pq and remove all duplicate
    pq.addAll(map.keySet());

    // obtain the character 2 by 2 from the maxheap to put in the result sb
    // until there is only one element(character) left in the maxheap
    // create a stringbuilder to build the result result
    StringBuilder sb = new StringBuilder();
    while (pq.size() > 1) {
      char first = pq.poll();
      char second = pq.poll();
      sb.append(first);
      sb.append(second);
      map.put(first, map.get(first) - 1);
      map.put(second, map.get(second) - 1);

      // insert the character back to the freq_map if the count in
      // hashmap of these two character are still > 0
      if (map.get(first) > 0) {
        pq.offer(first);
      }
      if (map.get(second) > 0) {
        pq.offer(second);
      }
    }

    if (!pq.isEmpty()) {
      // when there is only 1 element left in the maxheap
      // check the count, it should not be greater than 1
      // otherwise it would be impossible and should return ""
      if (map.get(pq.peek()) > 1) {
        return "";
      }
      else {
        sb.append(pq.poll());
      }
    }
    return sb.toString();
  }
}
