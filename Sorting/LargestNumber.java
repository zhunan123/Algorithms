package Sorting;

import java.util.Arrays;

public class LargestNumber {
    /**
     * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数
     * 样例 1:
     * 输入:[1, 20, 23, 4, 8]
     * 输出:"8423201"
     * 样例 2:
     * 输入:[4, 6, 65]
     * 输出:"6654"
     *
     * 贪心解法
     * 对于 numsnums 中的任意两个值 aa 和 bb，我们无法直接从常规角度上确定其大小/先后关系。
     * 但我们可以根据「结果」来决定 aa 和 bb 的排序关系：
     * 如果拼接结果 abab 要比 baba 好，那么我们会认为 aa 应该放在 bb 前面。
     * 另外，注意我们需要处理前导零（最多保留一位）。
     * */

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
