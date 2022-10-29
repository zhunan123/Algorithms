package ExpediaOA;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class GetMaximumEvenNumber {
    /**
     * A pair of string form a complementary pair if there is some permutation of their concatenation that is a
     * palindrome, For example, the strings "abac" and "cab" form a complementary pair since their concatenation is "abaccab"
     * which can be rearranged to from a palindrome, i.e "bcaaacb"
     * Given an array of n strings, find the number of complementary pairs that can be formed.
     * Example:
     * consider stringData = ["abc", "abcd", "bc", "adc"]
     * The following complementary pairs can be formed:
     * 1.{"abc", "abcd"}, concatenated string = "abcabcd" - arranged as palindrome -> "abcdcba"
     * 2.{"abc", "bc"}, concatenated string = "abcbc" - arranged as palindrome -> "bcacb"
     * 3.{"abcd", "abc"}, concatenated string = "abcdadc" - arranged as palindrome -> "acdbdca"
     *
     * ->return 3, the number of complementary paris;
     * */
    public static long getMaximumEvenSum(List<Integer> val) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : val) {
            if (num % 2 == 0) {
                if (num >= 0) {
                    res += num;
                }
            }else {
                pq.add(num);
            }
        }
        while (pq.size() >= 2) {
            int a1 = pq.poll();
            int a2 = pq.poll();
            if (a1 + a2 > 0) {
                res += a1 + a2;
            }else {
                break;
            }
        }
        return res;
    }
}
