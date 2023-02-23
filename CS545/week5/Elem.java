package CS545.week5;

public class Elem {

    private int key;
    private Object data;
    Elem next;

    public Elem(int key, Object data) {
      this.key = key;
      this.data = data;
      next = null;
    }

    public int getKey() {
      return key;
    }

    public Object getData() {
      return data;
    }

    @Override
    public String toString() {
      return "(" + key + ", " + data + ')';
    }
}
