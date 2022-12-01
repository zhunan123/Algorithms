package HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NameDeduplication {

    /**
     * 给一串名字，将他们去重之后返回。两个名字重复是说在忽略大小写的情况下是一样的。
     * 输入:["James", "james", "Bill Gates", "bill Gates", "Hello World", "HELLO WORLD", "Helloworld"]
     * 输出:["james", "bill gates", "hello world", "helloworld"]
     * */

    public List<String> nameDeduplication(String[] names) {
        List<String> answer = new ArrayList<>();
        //异常处理
        if (names.length == 0) {
            return answer;
        }
        HashSet<String> set = new HashSet<>();
        //小写处理
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toLowerCase();
            //判断是否出现过，没出现过就加入answer和set
            if (!set.contains(names[i])) {
                answer.add(names[i]);
                set.add(names[i]);
            }
        }
        return answer;
    }
}
