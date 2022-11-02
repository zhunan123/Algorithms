package Math501;

public class findMaxInAList {
    public static int findMax(int[] list, int n) {
        if (n == 1) {
            return list[0];
        }
        return Math.max(list[n - 1], findMax(list, n - 1));
    }

    public static void main(String[] args) {
        int[] list = new int[]{4,5,1,4,77,6};
        System.out.println(findMax(list, list.length));
    }
}
