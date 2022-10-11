package QueueStack;

import java.util.Stack;

public class EnhancedCalculatedUsingStack {

    public int calculate(String s) {

        /**
         * 输入："(1+(4+5+2)-3)+(6+8)"
         * 输出：23
         * */

        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int sign = 1;
        int res = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if (c == '+'){
                res += num * sign;
                num = 0;
                sign = 1;
            }else if (c == '-'){
                res += num * sign;
                num = 0;
                sign = -1;
            }else if (c == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if (c == ')'){
                res += num * sign;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        if(num != 0){
            res += num * sign;
        }

        return res;
    }
}
