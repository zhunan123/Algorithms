package ShoulderU.Stack.june1;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        // "(1+(14+5+2)-3)+(6+8)"

        // define sum
        int sum = 0;
        //define number if 15 like we need concactenate the number
        int number = 0;
        // define signal;
        int signal = 1;
        // create stack
        Stack<Integer> stack = new Stack<>();

        // start iterate the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // if is digit, update the number
                number = 10 * number + Character.getNumericValue(ch); // concatenate the number
            } else if (ch == '+') {
                // if char is +, 更新sum, which is signal * number + sum
                sum += signal * number;
                // reset number and set signal to 1
                number = 0;
                signal = 1;
            } else if (ch == '-') {
                // if char is -, 更新sum which is signal * number + sum
                sum += signal * number;
                // reset number and set signal to -1
                number = 0;
                signal = -1;
            } else if (ch == '(') {
                // if char is (, push sum and signal to stack
                stack.push(sum);
                stack.push(signal);

                // reset sum and signal
                sum = 0;
                signal = 1;
            } else if (ch == ')') {
                // if char is ), update sum and reset number to 0
                sum += signal * number;
                number = 0;

                // calculate the final sum
                sum *= stack.pop(); // get the previous signal
                // get the previous sum
                sum += stack.pop();
            }
        }
        if(number != 0) {
            sum += signal * number;
        }
        return sum;
    }
}
