package HashMap;

import java.util.HashMap;
import java.util.List;

public class CountGroups {

    /**
     * 给定一个n个邮件地址字符串的数组.
     * 求出电子邮件组的数量，每个组应具有多个电子邮件地址（地址可以重复）。如果两个字符串在转换后具有相同的值，则它们位于同一组中。
     * 邮件地址处理时遵循以下规则:
     * 在字符`'@'之前忽略所有的字符 '.'.
     * 在字符`'@'之前忽略字符 '+'以及它后面的所有子字符串.
     *
     * 输入: emails = ["abc.bc+c+d@jiuzhang.com", "abcbc+d@jiuzhang.com", "abc.bc.cd@jiuzhang.com"]
     * 输出: 1
     * 解释:
     * 这里只有一个email group. 是 "abcbc@jiuzhang.com".
     * */
    public int countGroups(List<String> emails) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for( String item : emails) {
            String name = item.substring(0, item.lastIndexOf('@'));
            String cp = item.substring(item.lastIndexOf('@'));
            if(name.indexOf('+') > -1) {
                name = name.substring(0, name.indexOf('+'));
            }
            name = name.replace(".", "");
            map.put(name+cp, map.getOrDefault(name+cp, 0) + 1);
        }
        for(Integer c : map.values()) {
            if(c > 1) count++;
        }
        return count;
    }
}
