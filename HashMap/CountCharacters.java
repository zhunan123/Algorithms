package HashMap;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {

    /**
     * 对一个字符串中的字符进行计数, 返回一个hashmap, key为字符, value是这个字符出现的次数.
     * 输入:
     * str = "abca"
     * 输出:
     * {
     *   "a": 2,
     *   "b": 1,
     *   "c": 1
     * }
     * */

    public Map<Character, Integer> countCharacters(String str) {
        // write your code here
        if (str == null){
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        char [] strArray = str.toCharArray();
        for (char c : strArray) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        return map;
    }
}
