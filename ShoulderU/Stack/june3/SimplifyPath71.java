package ShoulderU.Stack.june3;

import java.util.Stack;

public class SimplifyPath71 {
  /**
   String str = "/a/b///c/.././d/../f/";
   String[] parts = str.split("/");
   parts--->
   [ "", "a", "b", "", "", "c", "..", ".", "d", "..", "f", "" ]
   output: /a/b/f
   */

  /**
   * idea: first split the string, then if compoennt is empty string and . continue
   * if if component is .. need to back up 1 level so stack pop
   * else if is letter words or ... other stuff just added into stack
   * */
  public String simplifyPath(String path) {
    // split the original path with dellimeter "/"
    String[] strArr = path.split("/");
    // create stack
    Stack<String> stack = new Stack<>();

    // start loop the strArr
    for (int i = 0; i < strArr.length; i++) {
      String strComponent = strArr[i];
      if (strComponent.isEmpty() || strComponent.equals(".")) {
        // first if strComponent is empty or .(current directory) then ignore it and continue;
        continue;
      } else if (isLetterString(strComponent)) {
        //if is a path content (string letter like home), add to stack
        stack.add(strComponent);
      } else if (strComponent.equals("..")) {
        // if strComponent is ".." go up one level means we can just pop from stack
        // only pop when stack is not empty
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        // add other stuff to stack like ...
        // this is combione with condition 2 isLetter i think
        stack.add(strComponent);
      }
    }

    // create final string result using stringBuilder
    StringBuilder sb = new StringBuilder();
    // finally iterate through the stack and concatenate into the final path string add / to front.
    for (String str : stack) {
      sb.append("/");
      sb.append(str);
    }

    if (stack.isEmpty()){
      sb.append("/");
    }
    return sb.toString();
  }

  public boolean isLetterString(String str) {
    for (char ch : str.toCharArray()) {
      if (!Character.isLetter(ch)) {
        return false;
      }
    }
    return true;
  }
}
