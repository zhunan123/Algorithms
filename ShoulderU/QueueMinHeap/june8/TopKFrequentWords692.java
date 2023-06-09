package ShoulderU.QueueMinHeap.june8;

import java.util.*;

public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        // use maxheap

        // build the map first and set the priority queue as it's frequency
        Map<String, Integer> map = new HashMap<String, Integer>();
        // add string element into map
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Create a HashSet to check for duplicates
        HashSet<String> set = new HashSet<>();
        // initialize the max heap based on the frequency and add words into maxhap
        // create a custom comparator to handle words with the same frequency by their lexicographical order.
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int freqCompare = map.get(b) - map.get(a); // Compare frequencies
                if (freqCompare == 0) {
                    return a.compareTo(b); // Compare lexicographically if frequencies are the same
                }
                return freqCompare;
            }
        });
        // create result ans array
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (!set.contains(word)) { // only add to maxHeap when not duplicates
                // add word to set
                set.add(word);
                // add to maxHeap
                maxHeap.offer(word);
            }
        }

        // poll top K elements
        while (k-- > 0) {
            ans.add(maxHeap.poll());
        }
        return ans;
    }
}
