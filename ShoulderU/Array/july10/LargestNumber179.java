package ShoulderU.Array.july10;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
  public String largestNumber(int[] nums) {
    // edge case null
    if (nums.length == 0) {
      return "";
    }

    // convert int[] to string[]
    String[] strArr = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strArr[i] = String.valueOf(nums[i]);
    }

    //write the customized comparactor to compare each string (add 2 string together and compare bigger or smaller)
    Comparator<String> comparactor = new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        // return s1.compareTo(s2); // this is 从小到大排序
        return s2.compareTo(s1); //this is 从大到小排序
      }
    };

    // array sort using comparactor
    Arrays.sort(strArr, comparactor);

    // edge case 0
    if (strArr[0].equals("0")) {
      return "0";
    }

    //output number into final stringBuilder
    StringBuilder sb = new StringBuilder();
    for (String str : strArr) {
      sb.append(str);
    }
    // return final string
    return sb.toString();
  }
}
