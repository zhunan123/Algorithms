public class SwapIntegers {
    public void swapIntegers(int[] a, int index1, int index2) {
        // write your code here
        int t = a[index1];
        a[index1] = a[index2];
        a[index2] = t;
    }
}
