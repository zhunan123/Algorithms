public class LongestSemiSubstring {

    public int longestSubstring(String s){
        //b a a a b a a a b b b

        if(s==null || s.length()==0){
            return 0;
        }

        if(s.length() < 3){
            return s.length();
        }

        int start = 0;
        int maxLen = 0;
        int endDupCnt = 1;
        for(int end = 1;end<s.length();end++){
            char prev = s.charAt(end-1);
            char cur = s.charAt(end);
            if(prev == cur){
                endDupCnt++;
                if(endDupCnt == 3){
                    start = end - 1;
                    endDupCnt = 2;
                }
            }else{
                endDupCnt = 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
