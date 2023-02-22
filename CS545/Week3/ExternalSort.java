package CS545.Week3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExternalSort {
  /**
   * Implements external sort method
   *
   * @param inputFile  The file that contains the input list
   * @param outputFile The file where to output the sorted list
   * @param k          number of elements that fit into memory at once
   * @param m          number of chunks
   */
  public void externalSort(String inputFile, String outputFile, int k, int m) {
    // FILL IN CODE
    try {
      try(PrintWriter output = new PrintWriter(new FileWriter(inputFile,true)))
      {
        output.printf("%s\r\n", "");
      }
      catch (Exception e) {
        System.err.println("Not able to add new line");
      }
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
          if (strNum != null) {
            temp[j] = Integer.parseInt(strNum);
          } else {
            break;
          }
        }
        quickSort(temp, 0, temp.length - 1);
//                for (int q = 0; q < temp.length; q++)
//                    System.out.println(temp[q]);
        // created temp file, Write the sorted array to temp file
        FileWriter fw = new FileWriter(filePrefix + i + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        for (int c = 0; c < j; c++) {
          pw.println(temp[c]);
        }
        pw.close();
        fw.close();
      }
      br.close();
      fr.close();

      //open every file together and merge files with sorted array

      Path tempPathEven = Paths.get("temp0.txt");
      Path tempPathOdd = Paths.get("temp1.txt");
      Path sortedPath = Paths.get("temp" + (m) + ".txt");
      merge(sortedPath, tempPathOdd, tempPathEven);
      int newSortedIndex = m;

      for (int tempFile = 2; tempFile < m; tempFile++) {
        tempPathEven = sortedPath;
        tempPathOdd = Paths.get("temp" + tempFile + ".txt");
        newSortedIndex++;
        sortedPath = Paths.get("temp" + newSortedIndex + ".txt");
        merge(sortedPath, tempPathEven, tempPathOdd);
      }

      Path outputPath = Paths.get(outputFile);
      writingToFile(sortedPath, outputPath);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  private void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int p = partition(arr, left, right);
      quickSort(arr, left, p - 1);
      quickSort(arr, p + 1, right);
    }
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[left];

    while (left < right) {
      while (left < right && arr[right] > pivot) {
        right--;
      }
      if (left < right) {
        arr[left++] = arr[right];
      }
      while (left < right && arr[left] <= pivot) {
        left++;
      }
      if (left < right) {
        arr[right--] = arr[left];
      }

    }
    arr[left] = pivot;
    return left;
  }


  private void merge(Path sortedPath, Path pathOne, Path pathTwo) throws IOException {
    BufferedReader brOne = null;
    BufferedReader brTwo = null;
    BufferedWriter bw = null;
    String line1;
    String line2;

    try {
      bw = Files.newBufferedWriter(sortedPath);
      brOne = Files.newBufferedReader(pathOne);
      brTwo = Files.newBufferedReader(pathTwo);
      line1 = brOne.readLine();
      line2 = brTwo.readLine();

      while (line1 != null && line2 != null) {
        if (Integer.parseInt(line1) <= Integer.parseInt(line2)) {
          bw.write(line1);
          bw.newLine();
          line1 = brOne.readLine();
        } else {
          bw.write(line2);
          bw.newLine();
          line2 = brTwo.readLine();
        }
      }
      while (line1 != null) {
        bw.write(line1);
        bw.newLine();
        line1 = brOne.readLine();
      }

      while (line2 != null) {
        bw.write(line2);
        bw.newLine();
        line2 = brTwo.readLine();
      }
    } catch (IOException e) {
      throw new IOException();
    } catch (NullPointerException e) {
      System.out.println("You don't have any more values in File!");
    } finally {
      try {
        if (bw != null) {
          bw.close();
        }
        if (brOne != null) {
          brOne.close();
        }
        if (brTwo != null) {
          brTwo.close();
        }
      } catch (IOException e) {
        throw new IOException();
      }
    }
  }

  public void writingToFile(Path sortedPath, Path outputPath) {
    BufferedReader brSorted = null;
    BufferedWriter bwOutput = null;
    String line;

    try {
      brSorted = Files.newBufferedReader(sortedPath);
      bwOutput = Files.newBufferedWriter(outputPath);
      line = brSorted.readLine();
      while (line != null) {
        bwOutput.write(line);
        bwOutput.newLine();
        line = brSorted.readLine();
      }
    } catch (IOException e) {
      System.err.println("Cannot write to file.");
    } catch (NullPointerException e) {
      System.err.println("Line is null!");

    } finally {
      try {
        if (bwOutput != null) {
          bwOutput.close();
        }
        if (brSorted != null) {
          brSorted.close();
        }
      } catch (IOException e) {
        System.err.println("A null-pointer exception!");
      }
    }
  }


  public static void main(String[] args) {
    ExternalSort exSort = new ExternalSort();
    exSort.externalSort("CS545/Week3/inputFile.txt", "CS545/Week3/outputFile.txt", 4, 4);
  }
}
