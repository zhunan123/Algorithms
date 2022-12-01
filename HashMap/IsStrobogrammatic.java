package HashMap;

import java.util.HashMap;
import java.util.Map;

public class IsStrobogrammatic {

    public boolean isStrobogrammatic(String num) {
        /**
         * 一个镜像数字是指一个数字旋转180度以后和原来一样(倒着看)。例如，数字"69"，"88"，和"818"都是镜像数字。
         * 写下一个函数来判断是否这个数字是镜像的。数字用字符串来表示。
         *
         * 输入 : "69"
         * 输出 : true
         * */
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int i = 0;
        int j = num.length() - 1;
        while(i <= j) {
            if(!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
