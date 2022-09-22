package chapterTwoString;

import java.util.ArrayList;

public class ReverseWords {
    public static void main(String[] args){
        test("the sky is blue");
    }
    public static String test(String s){
        s = s.trim();
        int slen = s.length();
        int i = 0;
        int j = 0;
        ArrayList<String> alist = new ArrayList<>();
        while(i<slen && j < slen+1){
            while (i < slen && s.charAt(i) == ' '){
                i ++;
            }
            while (j < slen && s.charAt(j) != ' '){
                j ++;
            }
            if(i<j && j <= slen){
                String temp = s.substring(i,j);
                alist.add(temp);
            }
//            i = j + 1;
            i = j;
            j ++;

        }
        StringBuilder sb = new StringBuilder();
        for(int z=alist.size()-1;z>=0;z--){
            sb.append(alist.get(z));
            if(z != 0){
                sb.append(" ");
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
