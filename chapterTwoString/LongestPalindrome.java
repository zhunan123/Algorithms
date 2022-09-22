package chapterTwoString;

public class LongestPalindrome {
    public static void main(String[] args){
        test("abccccdd");
    }
    public static int test(String s){
        //cnt为计数数组
        //OddCount为是否有奇数次字符，1表示有，0表示无
        //ans为最终答案
        //现排序，整理一个hashamp
        //然后每个数字出现cnt / 2 * 2 次分别放string 两侧， 如出现技术粗oddcount++
        //最后就是所有cnt 相加，再加上oddcnt

        int[] arr = new int[52];
        int oddCnt = 0;
        int ans = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >=97){
                arr[26 + s.charAt(i) - 'a']++;
            }else {
                arr[s.charAt(i) - 'A']++;
            }
        }

        for(int j=0;j<52;j++){
            ans += arr[j] /2 *2;
            if(arr[j] % 2 ==1){
                oddCnt = 1;
            }
        }
        ans += oddCnt;
        return ans;
    }
}
