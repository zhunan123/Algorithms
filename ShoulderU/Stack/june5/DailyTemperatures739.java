package ShoulderU.Stack.june5;

import java.util.Stack;

public class DailyTemperatures739 {
    // brute force not good
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // monotonic decreasing stack
    public int[] dailyTemperatures(int[] temperatures) {
        // initialize stack
        Stack<Integer> stack = new Stack<>();
        // initialize length n
        int n = temperatures.length;
        // initialize ans array
        int[] ans = new int[n];

        // start looping
        for (int i = 0; i < n; i++) {
            // initilize the current  day temperature
            int currDay = temperatures[i];
            while (!stack.isEmpty()) { // while stack not empty, means theres is prev temp do not find high temperature
                // define prevDay index and prev day
                int prevDayIndex = stack.peek();
                int prevDay = temperatures[prevDayIndex];
                // if current day temperature > prev day temperatrues
                if (currDay > prevDay) { // if current day temperature > prev day temperature
                    // pop prev day temperature index
                    stack.pop();
                    // update the res array ans[prev] = i - prevDay(which is the prev day index)
                    ans[prevDayIndex] = i - prevDayIndex;
                } else {
                    // else if current day temperature < prev day temperature , just break
                    // if encounter a smaller temperature we can break while loop, then we added it to stack
                    break;
                }
            }
            // push the current temperatures index into stack
            stack.push(i);
        }
        // return final result
        return ans;
    }
}
