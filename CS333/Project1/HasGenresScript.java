package CS333.Project1;

import java.io.*;

public class HasGenresScript {

  public void start(String fname) {
    File file = new File("updated_has_genres.txt");
    BufferedReader br;
    try {
      FileWriter fw = new FileWriter(file);
      br = new BufferedReader(new FileReader(fname));
      String line = br.readLine();

      while (line != null) {
        String[] strArr = line.split(":");
        String movieid = strArr[0];
        int len = strArr.length;
        String genres = strArr[len - 1];
        String[] genres_arr = genres.split("[|]");
        for (int i = 0; i < genres_arr.length; i++) {
          fw.write(movieid + ":" + genres_arr[i]);
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
    HasGenresScript gs = new HasGenresScript();
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
    gs.start("movies.txt");
  }
}
