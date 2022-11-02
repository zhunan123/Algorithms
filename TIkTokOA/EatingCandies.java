package TIkTokOA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class EatingCandies {

    /**
     * There are n candies put from left to right on a table. The candies are numbered from left to right. The i-th candy has weight wi. Alice and Bob eat candies.
     * Alice can eat any number of candies from the left (she can't skip candies, she eats them in a row).
     * Bob can eat any number of candies from the right (he can't skip candies, he eats them in a row).
     * Of course, if Alice ate a candy, Bob can't eat it (and vice versa). They want to be fair. Their goal is to eat the same total weight of candies. What is the most number of candies they can eat in total?
     * Example
     * candies:[1000]
     * There is only candy, and it is not possible for Alice and Bob to eat the same total weight.
     * So the function should return 0
     * Example
     * candies:[1,2, 1]
     * Alice takes 1 candy from the left, and Bob takes 1 candy from the right.
     * So the function should return 2
     * */

    public static int maxCandiesCount(List<Integer> candies) {
        Deque<Integer> deque = new ArrayDeque<>(candies);
        int leftSum = 0;
        int rightSum = 0;
        int count = 0;
        int res = 0;
        while(!deque.isEmpty()) {
            if (leftSum == rightSum){
                res = count;
                leftSum += deque.pollFirst();
            } else if(leftSum < rightSum) {
                leftSum += deque.pollFirst();
            } else {
                rightSum += deque.pollLast();
            }
            count++;
        }
        if(leftSum == rightSum) {
            res = count;
        }
        return res;
    }
}
