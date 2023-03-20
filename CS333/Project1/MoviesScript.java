package CS333.Project1;

import java.io.*;

public class MoviesScript {

  public void start(String fname) {
    File file = new File("updated_movies.txt");
    BufferedReader br;
    try {
      FileWriter fw = new FileWriter(file);
      br = new BufferedReader(new FileReader(fname));
      String line = br.readLine();

      while (line != null) {
        String[] strArr = line.split(":");
        String movieid = strArr[0];

        String title = strArr[1];
        String new_title = title.split("[(]")[0].trim();
        String new_year = title.split("[(]")[1].replace(")", "");
        fw.write(movieid + ":" + new_title + ":" + new_year);
        fw.write("\n");

        line = br.readLine();
      }

      br.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    MoviesScript ms = new MoviesScript();
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
    ms.start("movies3.txt");
  }
}
