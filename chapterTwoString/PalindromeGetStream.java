package chapterTwoString;

import java.util.Arrays;

public class PalindromeGetStream {
    public int[] getStream(String s){
        //ababa [1,0,1,1,1]
        int countOdd = 0;
        int[] res = new int[s.length()];
        int[] letters = new int[26];
        for(int i=0;i <s.length();i++){
            int letterIndex = s.charAt(i) - 'a';
            letters[letterIndex]++;
            if(letters[letterIndex] % 2 ==1){
                countOdd++;
            }else {
                countOdd--;
            }
            res[i] = countOdd > 1 ? 0 : 1;
        }
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(letters));
        return res;
    }

    public static void main(String[] args){
        PalindromeGetStream gs = new PalindromeGetStream();
        gs.getStream("abdba");
    }
}
