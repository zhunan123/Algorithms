public class Largest {
    public static void main(String[] args){
        int[] nums = {2 ,5 ,10, -2, 8, 1, 9};

        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        System.out.println(max);
    }
}