package ShoulderU.QueueMinHeap.july26;

import java.util.*;

public class RearrangeStringkDistanceApart358 {
  public String rearrangeString(String s, int k) {
    // idea: craete a frequency array, with the help of priorityqueue add them to maxHeap based on frequency, eachtime we poll() top k elements from heap that elements having higher frequency in the frequency pq,
    // then if the heap size not 0, insert element to pq and pop next top k elements

    //idea step1: create frequency map, and add s to maxheap based on this frequency, than create a stringbuilder,
    //step2 while pq.size() >= k, write a for loop to poll top k elements and add to a new initialized array, write another for loop add to stringbuilder and decrease the frequency, for each polled element and if after decreaseing 1 frequency of element still > 0, need to add it back to heap with frequency - 1, need to have 2 for loop, in order to make element seperated by k element.
    //step3: then handle the not possible edge case -->in the last steps should have differenct elements left in the pq, if same elements left in the pq multiple times, means not poosiblae, meanse frequence of ele > 1, not possible---> like we have 2a's left, not possible, otherwise just add to sb again.
    // return final ans


    // https://www.youtube.com/watch?v=LAecOWxSk1M&ab_channel=InterviewPrepHelloWorld


    // Input: s = "aaabc", k = 3 not working in step 2 in first for loop will poll abc and add to array, second loop will add to sb, sb will start with abc, but we still have a left with frequency 2, then size = 2 < 3 then goes into last while loop, have 2 same a in pq, so not possible

    //edge case
    if (s.length() <= 1 || k <= 1) {
      return s;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> {
      int compare = map.get(b) - map.get(a);
      if (compare == 0) {
        return a.compareTo(b);
      }
      return compare;
    });

    // need to have hashset
    Set<Character> set = new HashSet<>();
    for (char ch : s.toCharArray()){
      set.add(ch);
    }
    Character[] arr = new Character[set.size()];
    int index = 0;
    for (char ch : set) {
      arr[index++] = ch;
    }

    for (char ch : arr) {
      heap.add(ch);
    }

    StringBuilder sb = new StringBuilder();
    while (heap.size() >= k) {
      Character[] arr2 = new Character[k];
      for (int i = 0; i < k; i++) {
        arr2[i] = heap.poll();
      }

      for (int i = 0; i < k; i++) {
        sb.append(arr2[i]);
        int count = map.get(arr2[i]);
        map.put(arr2[i], count - 1);
        if (map.get(arr2[i]) > 0) {
          heap.add(arr2[i]);
        }
      }
    }

    while (!heap.isEmpty()) {
      Character ch = heap.poll();
      sb.append(ch);
      int count = map.get(ch);
      map.put(ch, count - 1);
      if (map.get(ch) > 0){
        return "";
      }
    }

    return sb.toString();
  }
}
