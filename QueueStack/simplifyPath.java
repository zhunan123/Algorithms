package QueueStack;

import java.util.Stack;

public class simplifyPath {

    public String simplifyPath1(String path) {
        // write your code here
        Stack<String> stack = new Stack<String>();
        String[] arr = path.split("/");
        for(String s : arr){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(s.equals("") || s.equals(".")){
                continue;
            }else {
                stack.push(s);
            }
        }
        while(stack.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            StringBuilder tempStr = new StringBuilder(stack.pop());
            //如果就只是一个单词home的话就要reverse，好几个单词c/a/的话其实就一个letter，反不反无所谓
            tempStr = tempStr.reverse();
            tempStr.append("/");
            sb.append(tempStr);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        simplifyPath sp = new simplifyPath();
        sp.simplifyPath1("/a/./b/../c/");
        //----->/a/c
//        sp.simplifyPath1("/home/");
    }
}
