package Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class FindRelativeRanks {

    /**
     * 根据N名运动员的得分，找到他们的相对等级和获得最高分前三名的人，他们将获得奖牌：“金牌”，“银牌”和“铜牌”。
     * 输入: [5, 4, 3, 2, 1]
     * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * 说明：前三名运动员获得前三名最高分，因此获得“金牌”，“银牌”和“铜牌”。
     * 对于后两名运动员，你只需要根据他们的分数输出他们的相对等级。
     *
     * 使用hashmap记录好元素的原始位置，排序之后按原来元素的位置存放比赛排名。
     * */

    public String[] findRelativeRanks(int[] nums) {
        // write your code here
        HashMap<Integer,Integer> score = new HashMap();
        for (int i = 0; i < nums.length; i++)
            score.put(nums[i], i);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
        String[] answer = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            String res = String.valueOf(i + 1);
            if (i == 0)
                res = "Gold Medal";
            if (i == 1)
                res = "Silver Medal";
            if (i == 2)
                res = "Bronze Medal";
            answer[score.get(nums[i])] = res;
        }
        return answer;
    }
}
