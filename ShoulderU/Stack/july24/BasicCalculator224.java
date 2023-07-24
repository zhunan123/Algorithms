package ShoulderU.Stack.july24;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        // "(1+(14+5+2)-3)+(6+8)"
        // if is number ,update number
        // if is (, push sum and signal to stack, reset sum and signal
        // if is + -, calcualte sum based on number and signal, reset number and signal
        // if is ),  calculate sum with signal and number, reset number,calculate sum with previous signal and calculate sum with previous sum

        int num = 0;
        int sum = 0;
        int sig = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sum);
                stack.push(sig);

                sum = 0;
                sig = 1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                sum += sig * num;

                sig = 1;
                num = 0;
            } else if (c == '-') {
                sum += sig * num;

                sig = -1;
                num = 0;
            } else if (c == ')') {
                sum += sig * num;
                num = 0;

                if (!stack.isEmpty()) {
                    sum *= stack.pop();
                    sum += stack.pop();
                }
            }
        }
        if (num != 0) {
            sum += num * sig;
        }
        return sum;
    }
}
