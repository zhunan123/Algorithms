package chapterTwoString;

public class NumberOfOperations {
    public int numberOfOperations(String s) {
        //abcde, how many operation to palindrome abcba
        int op = 0;
        for(int i=0;i<s.length() / 2;i++){
            op += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));
        }
        return op;
    }
}
