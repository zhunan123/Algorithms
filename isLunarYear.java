public class isLunarYear {
    public boolean isLeapYear(int n) {
        // write your code here
        if(n % 400 ==0 || ((n % 4 == 0) && (n % 100 != 0))){
            return true;
        }
        return false;
    }
}
