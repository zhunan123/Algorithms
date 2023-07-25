package ShoulderU.Stack.july24;

import java.util.ArrayList;
import java.util.List;

public class MovingAveragefromDataStream346 {

  private List<Integer> list;
  private int size1;
  public MovingAveragefromDataStream346(int size) {
    this.size1 = size;
    list = new ArrayList<>(size1);
  }

  public double next(int val) {
    list.add(val);
    while (list.size() > size1){
      list.remove(0);
    }
    int sum = list.stream().mapToInt(Integer::intValue).sum();
    return (double) sum / list.size();
  }
}
