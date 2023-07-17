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


        //stack idea; loop heights array, push -1 first, if is ascending heights add to stack, ig decreasing heights, need to pop the stack peek, this is the current heights, current width will be the the one heights after and before stack peek which is i - stack.peek() - 1, then find maxHeights by compare previous max area and current height * current width
        // when the heights loop has loop to the end if stack is not empty and not -1. current height is stack pop. current width is heights.length - stack.peek() - 1, then calculate the maxArea
        // finally return  maxArea

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
