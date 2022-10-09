package QueueStack;

import java.util.Iterator;
import java.util.Stack;

public class BasicCalculatorUsingStack {
    public int calculate(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int num =  0;
        char presign = '+';

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                if (presign == '+') {
                    stack.push(num);
                }
                if(presign == '*'){
                    stack.push(stack.pop()*num);
                }
                if(presign == '/'){
                    stack.push(stack.pop() / num);
                }
                if(presign == '-'){
                    stack.push(-num);
                }

                num = 0;
                presign = s.charAt(i);
            }
        }

        int sum = 0;
        Iterator<Integer> it = stack.iterator();
        while(it.hasNext()){
            sum += it.next();
        }


        return sum;
    }
}
