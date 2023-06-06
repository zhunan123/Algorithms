package ShoulderU.Stack.june4;

import java.util.Stack;

public class AsteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        // create stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            // push first one or same sign asteroids into stack
            if (stack.isEmpty() || hasSameSign(current, stack.peek())) {
                stack.push(current);
            } else {
                // need to keep comparing, keep collision! until there is no more colllision
                // stack is not empty and if the top element of the stack has a different sign than the current asteroid
                // so if stack is not empty and top of stack and current has equal same, we break while loop
                // only go inside the loop if difference sign
                while (!stack.isEmpty() && !hasSameSign(current, stack.peek())) {
                    int prev = stack.peek();
                    // prev and current must be different sign
                    // resolve collision, push back prev if prev has a lartger abs value
                    if (Math.abs(prev) > Math.abs(current)) {
                        break;
                    } else if (Math.abs(prev) < Math.abs(current)) {
                        stack.pop();
                        continue;
                    } else if (Math.abs(prev) == Math.abs(current)) {
                        // Both asteroids annihilate each other
                        stack.pop();
                        break;
                    }
                }
            }
        }
        // create result int[]
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public boolean hasSameSign(int num1, int num2) {
        return ((num1 > 0 && num2 > 0) || (num1 < 0 && num2 < 0));
    }
}
