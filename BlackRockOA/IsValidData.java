package BlackRockOA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidData {
    /**
     * You are writing a program to analyze the financial data for a set of companies, Your coworker gives you a text file of
     * company data, However, you are worried that your coworker didn't type the data in correctly. Write a program that will
     * tell you if the data is correctly formatted.
     * [
     *   {
     *     company_name: (BlackRock)
     *     ticker: (BLK)
     *     stock_price: {
     *       2022-04-03: ($930)
     *       2022-04-02: ($932)
     *
     *     }
     *   },
     *   {
     *     company_name: (Apple)
     *     ticker: (APPL)
     *     stock_price: {
     *       2022-04-03: ($175) 2022-04-02: ($178)
     *
     *     }
     *   }
     * ]
     *
     * Output: String - valid data format or not;
     *
     * A file is formatted correctly if each opening parenthesis : ( { [ is closed out with its respective closing
     * parenthesis ) } ]. The open bracket character ( matches ) on the same line, however, { and [ may match
     * over multiple lines, Incorrect data could look like:
     * [
     *   {
     *     company_name: (BlackRock(
     *     ticker: (BLK{
     *     stock_price: {
     *       2022-04-03: ($930]
     *       2022-04-02: ($932)
     *
     *     }
     *   }
     * ]
     * */

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        while ((line = in.readLine()) != null) {
           int left = 0;
           for (char c : line.toCharArray()) {
               if (c == '(') {
                   left ++;
               } else if (c == ')') {
                   if ( left <= 0) {
                       flag = false;
                   } else {
                       left--;
                   }
               } else if (c == '[' || c == '{') {
                   stack.push(c);
               } else if (c == ']') {
                   if (stack.peek() == '[') {
                       stack.pop();
                   } else {
                       flag = false;
                   }
               } else if (c == '}') {
                   if (stack.peek() == '{') {
                       stack.pop();
                   } else {
                       flag = false;
                   }
               }
           }
        }
        if (!stack.isEmpty()) {
            flag = false;
        }
        if (flag) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
