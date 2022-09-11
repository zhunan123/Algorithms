import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public List<String> fizzBuzz(int n) {
        // write your code here
        ArrayList<String> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if((i % 3 == 0) && (i % 5 == 0)){
                list.add("fizz buzz");
            } else if(i % 5 == 0){
                list.add("buzz");
            } else if(i % 3 == 0){
                list.add("fizz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
