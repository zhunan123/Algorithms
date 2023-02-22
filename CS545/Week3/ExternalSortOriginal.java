package CS545.Week3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


public class ExternalSortOriginal {

  private static int partition3(int[] arr, int low, int high) {
    int pivotIndex = (low + high) / 2;
    int pivotElement = arr[pivotIndex];
    //swap(high, pivotIndex, arr);
    int temp = arr[pivotIndex];
    arr[pivotIndex] = arr[high];
    arr[high] = temp;

    int i = low;
    int j = high - 1;
    while (i <= j) {
      while ((i <= j) && (arr[i] < pivotElement))
        i++;
      while ((i <= j) && (arr[j] >= pivotElement))
        j--;
      if (i <= j) {
        int temp1 = arr[j];
        arr[j] = arr[i];
        arr[i] = temp1;
        i++;
        j--;
      }
    }
    int temp2 = arr[high];
    arr[high] = arr[i];
    arr[i] = temp2;
    return i;
  }

  private static void quickSort(int[] arr, int low, int high) {
    int pivotIndex;
    if (low < high) {
      pivotIndex = partition3(arr, low, high);
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  private void merge(File sortedFile, File file1, File file2) throws IOException {
    BufferedReader br1;
    BufferedReader br2;
    BufferedWriter bw;
    String line1;
    String line2;

    try {
      bw = new BufferedWriter(new FileWriter(sortedFile));
      br1 = new BufferedReader(new FileReader(file1));
      br2 = new BufferedReader(new FileReader(file2));
      line1 = br1.readLine();
      line2 = br2.readLine();

      while (line1 != null && line2 != null) { //start compare between 2 files, similar as merge step
        if (Integer.parseInt(line1) <= Integer.parseInt(line2)) {
          bw.write(line1);
          bw.newLine();
          line1 = br1.readLine();
        } else {
          bw.write(line2);
          bw.newLine();
          line2 = br2.readLine();
        }
      }
      while (line1 != null) { //file2 is finished but file 1 still have lefts
        bw.write(line1);
        bw.newLine();
        line1 = br1.readLine();
      }
      while (line2 != null) {
        bw.write(line2);
        bw.newLine();
        line2 = br2.readLine();
      }

      bw.close();
      br1.close();
      br2.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  private void writeToFile(File tempFile, File outputFile) {
    BufferedReader br;
    BufferedWriter bw;
    String line;

    try {
      br = new BufferedReader(new FileReader(tempFile));
      bw = new BufferedWriter(new FileWriter(outputFile));
      line = br.readLine();
      while (line != null) {
        bw.write(line);
        bw.newLine();
        line = br.readLine();
      }

      bw.close();
      br.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void externalSort(String inputFile, String outputFile, int k, int m) {
    // FILL IN CODE
    try {

      //read file, add k elements to temp array then sort it.
      FileReader fr = new FileReader(inputFile);
      BufferedReader br = new BufferedReader(fr);
      int[] temp = new int[k];
      String filePrefix = "temp";

      int i;
      int j;
      for (i = 0; i < m; i++) {  //iterate m chunk
        for (j = 0; j < k; j++) {  //iterate k elements in each chunk
          String strNum = br.readLine();
          if (strNum!= null) {
            temp[j] = Integer.parseInt(strNum);
          } else {
            break;
          }
        }
        quickSort(temp, 0, temp.length - 1);

        // created temp file, Write the sorted array to temp file
        FileWriter fw = new FileWriter(filePrefix + Integer.toString(i) + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        for (int c = 0; c < j; c++) {
          pw.println(temp[c]);
        }
        pw.close();
        fw.close();
      }
      br.close();
      fr.close();


      File tempFileFirst = new File("temp0.txt");
      File tempFileSecond = new File("temp1.txt");
      File tempSortedFile = new File("temp" + m + ".txt");
      merge(tempSortedFile, tempFileFirst, tempFileSecond);
      int tempSortedFileIndex = m;

      for (int curTempFile = 2; curTempFile < m; curTempFile++) {
        tempFileFirst = tempSortedFile;
        tempFileSecond = new File("temp" + curTempFile + ".txt");
        tempSortedFileIndex++;
        tempSortedFile = new File("temp" + tempSortedFileIndex + ".txt");
        merge(tempSortedFile, tempFileFirst, tempFileSecond);
      }

      writeToFile(tempSortedFile, new File(outputFile));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    ExternalSortOriginal exSort = new ExternalSortOriginal();
    exSort.externalSort("CS545/Week3/inputFile.txt", "CS545/Week3/outputFile.txt", 4, 4);;
  }
}
