package ShoulderU.Stack.june5;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String s) {
        // create stack
        Stack<Character> stack = new Stack<>();

        // start looping
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) { // if stack is not empty
                char prev = stack.peek();
                // if current element  = stack top element, means find deplicate we need to pop
                if (s.charAt(i) == prev) {
                    // stack pop the top element
                    stack.pop();
                    // after pop the prev one, and we dont want to add the current one, then just continue with the for loop
                    continue;
                }
            }
            // push current element
            stack.push(s.charAt(i));
        }

        // create string builder, character can be added into string builder
        StringBuilder sb = new StringBuilder();
        // iterate stack and loop to string
        for (int i = stack.size() - 1; i >= 0; i--) {
            // iterate stack and pop stack add to frone of string builder
            sb.insert(0, stack.pop());
        }
        // convert string builder to string and return result
        return sb.toString();
    }
}
