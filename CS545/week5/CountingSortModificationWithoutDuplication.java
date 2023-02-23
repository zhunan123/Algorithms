package CS545.week5;

import java.util.Arrays;

public class CountingSortModificationWithoutDuplication {

  public static void countingSortModificaitonWithOutDup(int[] arr, int maxValue) {
    int[] counterArray = new int[maxValue];
    for (int i = 0; i < arr.length; i++) { //counter array
      counterArray[arr[i]]++;
    }

    for (int i = 1; i < counterArray.length; i++) { //this is modified counterArray
      counterArray[i] = counterArray[i] + counterArray[i - 1];
    }

    int[] arrB = new int[arr.length];
    for (int i = 0; i < arr.length; i++) { //final output array
      arrB[counterArray[arr[i]] - 1] = arr[i];
      counterArray[arr[i]]--; //add  dis line to remove duplicates
    }

    //convert arrB back to arr
    for (int i = 0; i < arr.length; i++){
      arr[i] = arrB[i];
    }
  }


  public static void main(String[] args) {
    int[] arr = {3, 1, 2, 4, 2, 2, 9, 1, 6};
    countingSortModificaitonWithOutDup(arr, 10);
    System.out.println(Arrays.toString(arr));
  }
}
