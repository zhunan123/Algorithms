package CS333.Project1;

import java.io.*;
import java.util.Arrays;

public class TagScript {

  public void start(String fname) {
    File file = new File("updated_tags.txt");
    BufferedReader br;
    try {
      FileWriter fw = new FileWriter(file);
      br = new BufferedReader(new FileReader(fname));
      String line = br.readLine();

      while (line != null) {
        String[] strArr = line.split(":");
        int len = strArr.length;

        String userid = strArr[0];
        String movieid = strArr[1];
        String timeStamp = strArr[len - 1];

        String[] tag_array = Arrays.copyOfRange(strArr, 2, len - 1);
        String tag_str = String.join(" ", tag_array);

        fw.write(userid + ":" + movieid + ":" + tag_str + ":" + timeStamp);
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
    TagScript ts = new TagScript();
    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
    ts.start("tags.txt");
  }
}
