package ShoulderU.Stack.july17;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // // brute forct (not-working)
        // for (int i = 0; i < heights.length; i++) { //define start heights
        //     // define end heights
        //     for (int j = i; j < heights.length; j++) {
        //         // find min heights
        //         int minHeight = Integer.MAX_VALUE;
        //         for (int k = i; k <= j; k++) {
        //             minHeight = Math.min(minHeight, heights[k]);
        //         }
        //         maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        //     }
        // }
        // return maxArea;

        // //better brute force - (not working)
        // for (int i = 0; i < heights.length; i++) {
        //     int min = Integer.MAX_VALUE;
        //     for (int j = i; j < heights.length; j++) {
        //         min = Math.min(min, heights[j]);
        //         maxArea = Math.max(maxArea, min * (j - i + 1));
        //     }
        // }
        // return maxArea;


        //stack idea; loop heights array, push -1 first, if is ascending heights add to stack,
        // ig decreasing heights, need to pop the stack peek, this is the current heights,
        // current width will be the the one heights after and before stack peek which is i - stack.peek() - 1,
        // then find maxHeights by compare previous max area and current height * current width
        // when the heights loop has loop to the end if stack is not empty and not -1. current height is stack pop.
        // current width is heights.length - stack.peek() - 1, then calculate the maxArea
        // finally return  maxArea

        // key is i - stack.peek() - 1, find the maximum area at least 1 full bar rectangle.
        // when we poll 6 since 2 is smaller, so we have width 4(current i) - 2(stack.peek() after poll) - 1 = 1,
        // so when we poll 6,  we have maxArea which is exact area of bar 6 which is 6 * 1 = 6, then in the while loop,
        // we have top peek as 5, 5 > 2 so pop 5, we have full bar 5 with length 4(current i)-1(stack.peek() after poll) - 1 which is 2.
        // so max area is 5 * 2 = 10 which indicates the area for bar 5 and bar 6,
        // then in the stack, if we still have something left, which will be the bar with lowest heights,
        // so make them heights as current high, width will be length of heightd array - stack peek - 1 and then caluclate the maxArea

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek()  - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
}
