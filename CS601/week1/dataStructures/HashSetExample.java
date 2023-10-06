package week1.dataStructures;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("cat");
        words.add("mail");
        words.add("dog");
        words.add("cat"); // won't add it again
        System.out.println(words); //don’t know the order

    }
}
