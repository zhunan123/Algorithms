import java.util.Arrays;

//javac -encoding UTF-8 selectionSort.java
public class selectionSort {
    public static void main (String[] args) {
        int[] arr  = {10 ,2 ,5, -2, 8, 1, 9};

        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小的minIndex
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //交换minIndex和i
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }

        System.out.println("the sorted new array is: " + Arrays.toString(arr));
    }
}