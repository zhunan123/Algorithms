package CS333.Project1;

import java.io.*;
import java.util.Arrays;

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
        int len = strArr.length;
        String movieid = strArr[0];

        String[] title_array = Arrays.copyOfRange(strArr, 1, len - 1);
        String titleAndYear = String.join(" ", title_array);

        String[] title_arr = titleAndYear.split("[(]");
        int len_title = title_arr.length;
        String[] title = Arrays.copyOfRange(title_arr, 0, len_title - 1);
        String title_str = String.join(" ", title).replace(")", "");

        String[] year_arr = Arrays.copyOfRange(title_arr, len_title - 1, len_title);
        String new_year = String.join(" ", year_arr).replace(")", "");


        fw.write(movieid + ":" + title_str.trim() + ":" + new_year);
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
    ms.start("movies.txt");
  }
}
