package chapterTwoString;

public class JudgeStudentLate {
    public static void main(String[] args){
        test("LLDL");
    }
    public static boolean test(String record){
        // Write your code here.
        int maxL = 1, countL = 0;
        int countD = 0;
        int len = record.length();

        for(int i=0;i<len;i++){
            if(record.charAt(i) == 'D'){
                countD++;
            }
            if(record.charAt(i) == 'L'){
                countL++;
                if(i==0){
                    continue;
                }
                if(record.charAt(i) == record.charAt(i - 1)){
                    maxL++;
                }
            }else {
                maxL=1;
            }
        }
        if(countD >=2 || maxL >=3){
            return true;
        }
        return false;
    }
}
