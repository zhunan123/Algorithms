package Math501;

public class FindSquareSum {

    public static int squareSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n ^ 2 + squareSum(n - 1);
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6,7,8};
        int res = squareSum(list[4]);
        System.out.println(res);
    }
}
