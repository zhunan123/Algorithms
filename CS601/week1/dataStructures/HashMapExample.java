package week1.dataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    /**
     *     Compute the # of occurrences for each word in the array of words
     *     @param words - an array of strings
     */
    public static void computeFrequencies(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String w : words) {
            if (frequencyMap.containsKey(w)) {
                frequencyMap.put(w, frequencyMap.get(w) + 1);
            } else {
                frequencyMap.put(w, 1);
            }
        }
        // output all key - value pairs
        for (String key : frequencyMap.keySet()) {
            System.out.println(key + "->" + frequencyMap.get(key));
        }

        // output entry -> key -> value
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry + "->" + entry.getKey() + "->" + entry.getValue());
        }
    }

    /**
     * Computes a map where the lengths are the keys, and the set of words that have this length is the value.
     * @param words array of strings
     */
    public static void computeLengthToWords(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String w : words) {
            int length = w.length();
            if (map.containsKey(length)) {
                Set<String> set = map.get(length);
                set.add(w);
            } else {
                Set<String> set = new HashSet<>();
                set.add(w);
                map.put(length, set);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "cat", "dog", "cat", "bird", "elephant", "monkey", "dog", "bull" };
        System.out.println("Frequencies: ");
        computeFrequencies(words);
        System.out.println(System.lineSeparator() + "Length to words: ");
        computeLengthToWords(words);
    }

}
