package QueueStack;

import java.util.Stack;

public class ExpressionExpandUsingStack {
    //if number *10 + prev Number
    //if'[' push number
    //if ']' popstack count stack push
    // if char direct push
    //popstack new stack !stackempty && peek instance string new stack push stack pop
    //sb !newstack empty sb apprend return

    //S = 3[2[ad]3[pf]]xyz----->"adadpfpfpfadadpfpfpfadadpfpfpfxyz"

    public String popStack(Stack<Object> stack) {
        Stack<Object> s1 = new Stack<Object>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)){
            s1.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()){
            sb.append(s1.pop());
        }
        return sb.toString();
    }
    public String expressionExpand(String s) {
        // write your code here

        Stack<Object> stack = new Stack<Object>();
        int num = 0;
        char[] clist = s.toCharArray();
        for(char c : clist){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else if(c == '['){
                stack.push(Integer.valueOf(num));
                num = 0;
            }
            else if(Character.isLetter(c)){
                stack.push(String.valueOf(c));
            }
            else if(c == ']'){
                String str = popStack(stack);
                int count = (Integer) stack.pop();
                for(int i=0;i<count;i++){
                    stack.push(str);
                }
            }
        }
        return popStack(stack);
    }
}
