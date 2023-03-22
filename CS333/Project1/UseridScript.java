package CS333.Project1;

import java.io.*;
import java.util.HashSet;

public class UseridScript {

  public void start(String fname) {
    File file = new File("users.txt");
    BufferedReader br;
    try {
      FileWriter fw = new FileWriter(file);
      br = new BufferedReader(new FileReader(fname));
      String line = br.readLine();
      HashSet<String> hs = new HashSet<String>();

      while (line != null) {
        String[] strArr = line.split(":");
        if(hs.add(strArr[0])){
          fw.write(strArr[0]);
          fw.write("\n");
        }
        line = br.readLine();
      }

      br.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void generateUniqieID(String fname) {
    File file = new File("unique_tags.txt");
    BufferedReader br;
    try {
      FileWriter fw = new FileWriter(file);
      br = new BufferedReader(new FileReader(fname));
      String line = br.readLine();
      HashSet<String> hs = new HashSet<String>();

      while (line != null) {
        String[] strArr = line.split(":");
        if(hs.add(strArr[0])){
          fw.write(strArr[0]);
          fw.write("\n");
        }
        line = br.readLine();
      }

      br.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void mergeFile(String filePath1, String filePath2) throws IOException {
    BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
    BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
    BufferedWriter writer = new BufferedWriter(new FileWriter("new_users.txt"));

    String line1 = reader1.readLine();
    String line2 = reader2.readLine();

    while (line1 != null || line2 != null) {
      if (line1 != null && line2 != null) {
        int num1 = Integer.parseInt(line1);
        int num2 = Integer.parseInt(line2);

        if (num1 <= num2) {
          writer.write(String.valueOf(num1));
          writer.newLine();
          line1 = reader1.readLine();
        } else {
          writer.write(String.valueOf(num2));
          writer.newLine();
          line2 = reader2.readLine();
        }
      } else if (line1 != null) {
        writer.write(line1);
        writer.newLine();
        line1 = reader1.readLine();
      } else if (line2 != null) {
        writer.write(line2);
        writer.newLine();
        line2 = reader2.readLine();
      }
    }

    reader1.close();
    reader2.close();
    writer.close();
  }

  public static void main(String[] args) throws IOException {
    UseridScript us = new UseridScript();
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
//    us.start("ratings.txt");
//    us.generateUniqieID("updated_tags.txt");
    us.mergeFile("users.txt", "unique_tags.txt");
  }
}
