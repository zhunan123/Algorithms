package ShoulderU.QueueMinHeap.june8;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            int compareFreq = map.get(b) - map.get(a);
            if (compareFreq == 0) { // when they have the same frequency of character
                return a.compareTo(b); // do a regular compareTo
            }
            return compareFreq;
        });

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            maxHeap.offer(s.charAt(i));
        }

        while (!maxHeap.isEmpty()) {
            ans += maxHeap.poll();
        }
        return ans;
    }
}
