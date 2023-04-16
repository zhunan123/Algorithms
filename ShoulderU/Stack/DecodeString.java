package ShoulderU.Stack;

import java.util.Stack;

public class DecodeString {

  /**
   * Given an encoded string, return its decoded string.
   *
   * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
   *
   * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
   *
   * The test cases are generated so that the length of the output will never exceed 105.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "3[a]2[bc]"
   * Output: "aaabcbc"
   * Example 2:
   *
   * Input: s = "3[a2[c]]"
   * Output: "accaccacc"
   * */

  /**
   * 两个stack，[ 左边数字就存进图number stack，[右边 letter 就存进去string stack
   * 	a + 2 * b
   * 字母添加current string stack，数字numberstring stack，左括号存stack 并且清零，
   * 右括号pop 把前面的都换成string pop之前的string 和number number* 当前的string + string, a + 2 * b
   *
   * 最先设置number和string两个stack，variable count和stringRes， 当时数字更新count，当时letter更新stringRes，
   * [的时候pushcount进numStack，push stringRes进入string stack， 并且清零count和stringRes。当是] 的时候，pop numStack = 2和stringStack = a，
   * 写个for loop做a + 2b
   * */

  public String decodeString(String s) {
    Stack<Integer> numberStack = new Stack<>();
    Stack<String> strStack = new Stack<>();

    int count = 0;
    String str = "";

    for (int i = 0; i < s.length(); i++)  {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        //need to concatenate all the number say like 100, 就只有一位的时候就是count 本来是0, 0 * 10 + 1 = 1, 第二位是0, count 本来是1， 1 * 10 + 0 = 10，count第三位是0， 之前的count * 10 + 0 = 100
        count = 10 * count + s.charAt(i) - '0';
      } else if (s.charAt(i) == '[') {
        numberStack.push(count);
        strStack.push(str);

        count = 0;
        str = "";
      } else if (s.charAt(i) == ']'){
        int poppedNum = numberStack.pop();
        String poppedString = strStack.pop();
        for (int j = 0; j < poppedNum; j++) {
          //这里就是实现a + 2 * b, a就是poppedNum只用加一遍，b 就是poppedString，要加poppedNUm遍
          poppedString += str;
        }
        //更新str从poppedString, 更新到general str
        str = poppedString;
      } else {
        str += s.charAt(i);
      }
    }

    return str;
  }
}
