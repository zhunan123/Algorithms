package HashMap;

import java.util.HashMap;
import java.util.Map;

public class DistinguishUsername {
    /**
     * 题解：利用HashMap存储各个用户名出现的次数，初次出现原样存入答案，否则将次数转为字符串加到原字符串后面
     *
     * 给出一组用户名，如果有重复的用户名，则在用户名后添加数字区别，并返回修改后的数组。
     * 输入：["aa", "bb", "cc", "bb", "aa", "aa", "aa"]
     * 输出：["aa","bb","cc","bb1","aa1","aa2","aa3"]
     * 解释：
     * "bb"第二次出现输出为"bb1"
     * "aa"第二次出现输出为"aa1"
     * "aa"第三次出现输出为"aa2"
     * "aa"第四次出现输出为"aa3"
     * */

    public String[] DistinguishUsername(String[] names) {
        Map<String, Integer> map = new HashMap<String, Integer>();	//HashMap计数
        for(int i = 0; i < names.length; i++){
            if(map.containsKey(names[i])){
                int count = map.get(names[i]);
                map.put(names[i],count + 1);	//第一次出现原样存入答案
                names[i] += String.valueOf(count);	//将数字转为字符串加到原字符串后面
            }
            else map.put(names[i],1);
        }
        return names;
    }
}
