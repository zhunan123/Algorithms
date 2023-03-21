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

  public static void main(String[] args) {
    UseridScript us = new UseridScript();
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
    us.start("ratings.txt");
  }
}
