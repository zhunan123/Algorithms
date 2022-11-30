package HashMap;

import java.util.*;

public class IsSentenceSimilarity {

    /**
     * 给出两个句子words1和words2（每个用一个字符串数组表示），和一个相似词对数组pairs，你需要判断两个句子是否相似。
     * 例如，如果相似词对是pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]，
     * 那么words1 = great acting skills和words2 = fine drama talent是相似的。
     * 需要注意，相似关系是不可传递的。例如，如果"great"和"fine"相似，"fine"和"good"相似，"great"和"good"不是一定相似的。
     * 然而，相似性是对称的。例如，"great"和"fine"相似，则"fine"和"great"也是相似的，这两者是等价的。
     * 另外，一个单词永远与它本身相似。例如，句子words1 = ["great"], words2 = ["great"], pairs = []是相似的，尽管没有相似词对。
     * 最后，两个句子只有在单词数相等的情况下才可能相似。所以，句子words1 = ["great"]永远不可能与句子words2 = ["doubleplus","good"]相似。
     *
     * 输入: words1 = ["great","acting","skills"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
     * 输出: true
     * 解释:
     * "great"和"fine"相似
     * "acting"和"drama"相似
     * "skills"和"talent"相似
     *
     * 输入: words1 = ["fine","skills","acting"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
     * 输出: false
     * 解释:
     * "fine"和"fine"相同
     * "skills"和"drama"不相似
     * "acting"和"talent"不相似
     * */

    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        //特殊情况处理
        if (words1 == null && words2 == null) {
            return true;
        }
        if (words1 == null || words2 == null) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> map = new HashMap<>();
        //构建Map
        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            //word1 = word2, 加入hashmap
            map.putIfAbsent(word1, new HashSet<String>());
            map.get(word1).add(word2);
            //word2 = word1, 加入hashmap
            map.putIfAbsent(word2, new HashSet<String>());
            map.get(word2).add(word1);
        }

        for (int i = 0; i < words1.length; i++) {
            //如果相当，继续比较下一个词
            if (words1[i].equals(words2[i])) {
                continue;
            }
            //如果key不在map中
            //或者不存在words1[i] = words2[i],返回false
            if (map.get(words1[i]) == null ||
                    !map.get(words1[i]).contains(words2[i])){
                return false;
            }
        }
        return true;
    }
}
