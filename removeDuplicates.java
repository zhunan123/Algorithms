import java.util.HashMap;

public class removeDuplicates {
    public static void main(String[] args){
        int a[] = { 1, 1, 2, 2, 2,44,44,33,33 };
        removeDuplicate(a);
    }
    public static void removeDuplicate(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0;i < arr.length; i++) {
            if (mp.get(arr[i]) == null){
                mp.put(arr[i], 1);
            }else {
                //直接进入该for 循环的下一个element循环
                continue;
            }
        }
        System.out.println(mp.keySet());
    }
}