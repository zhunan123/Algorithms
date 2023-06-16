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
    while (pq.size() > 1) { // while pq has size greater than 1 we will continue loop until one left
      // pq poll() first and second 2 character
      char first = pq.poll();
      char second = pq.poll();
      // add first and second element to sb
      sb.append(first);
      sb.append(second);
      // update freq for polled character in the map
      map.put(first, map.get(first) - 1);
      map.put(second, map.get(second) - 1);

      // if freq of character in map is greater > than 0, means still elements left, so add the character back to pq
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

      // if only one character in the pq with freq > 1 so no way to not letting this not adjacency
      // check the freq of this character in the map, if the freq is greater than 1 means no way to arrange not possible
      if (map.get(pq.peek()) > 1) {
        return "";
      }
      else {
        // otherwise add the last character to sb
        sb.append(pq.poll());
      }
    }

    return sb.toString();
  }
}
