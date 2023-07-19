package ShoulderU.Stack.july18;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath71 {
  /**
   String str = "/a/b///c/.././d/../f/";
   String[] parts = str.split("/");
   parts--->
   [ "", "a", "b", "", "", "c", "..", ".", "d", "..", "f", "" ]
   output: /a/b/f


   String str1 = ""; // An empty string str1.isEmpty() check empty string
   ArrayDeque.addLast = stack.push()
   ArrayDeque.removeLast = stack.pop()
   */
  public String simplifyPath(String path) {
    String[] strArr = path.split("/");
    Deque<String> stack = new ArrayDeque<>();

    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i].equals(".") || strArr[i].isEmpty()) {
        continue;
      } else if (strArr[i].equals("..")) {
        if (!stack.isEmpty()) {
          stack.removeLast(); // stack.pop()
        }
      } else {
        stack.addLast(strArr[i]);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String str : stack) {
      sb.append("/");
      sb.append(str);
    }
    if (stack.isEmpty()) {
      sb.append("/");
    }
    return sb.toString();
  }
}
