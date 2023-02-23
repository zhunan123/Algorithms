package CS545.week5;

import java.util.Arrays;

public class CountingSortModification {

  public static void countingSortModificaiton(int[] arr, int maxValue) {
    int[] counterArray = new int[maxValue];
    for (int i = 0; i < arr.length; i++) {
      counterArray[arr[i]]++;
    }

    for (int i = 1; i < counterArray.length; i++) { //this is modified counterArray
      counterArray[i] = counterArray[i] + counterArray[i - 1];
    }

    int[] arrB = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      arrB[counterArray[arr[i]] - 1] = arr[i];
    }

    //convert arrB back to arr
    for (int i = 0; i < arrB.length; i++){
      arr[i] = arrB[i];
    }
  }


  public static void main(String[] args) {
    int[] arr = {5, 9, 1, 4, 2};
    countingSortModificaiton(arr, 10);
    System.out.println(Arrays.toString(arr));
  }
}
