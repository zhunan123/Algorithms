package CS545.week5;

public class generateRandomNumber {
  private static int findRandomNumber(int low, int high) {
    return low + (int)(Math.random() * (high - low + 1));
  }

  public static int findMedian(int a, int b, int c) {
    int[] arr =new int[3];
    arr[0] = a;
    arr[1] = b;
    arr[2] = c;

    if (arr[0] > arr[1]) {
      int temp = arr[1];
      arr[1] = arr[0];
      arr[0] = temp;
    }
    if (arr[1] > arr[2]) {
      int temp = arr[2];
      arr[2] = arr[1];
      arr[1] = temp;
    }
    if (arr[0] > arr[1]) {
      int temp = arr[1];
      arr[1] = arr[0];
      arr[0] = temp;
    }

    System.out.println(arr[1]);
    return arr[1];
  }


  public static void findDifferentNumber(int low, int high) {
    int ranNum1 = findRandomNumber(low, high);
    int ranNum2 = findRandomNumber(low, high);
    while (ranNum1 == ranNum2) {
      ranNum2 = findRandomNumber(low, high);
    }
    int ranNum3 = findRandomNumber(low, high);
    while (ranNum3 == ranNum1 || ranNum3 == ranNum2) {
      ranNum3 = findRandomNumber(low, high);
    }
  }

  public static void main(String[] args) {
//    findDifferentNumber(0, 9);
    findMedian(3,3,3);
  }
}
