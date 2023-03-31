package CS545.week6.stack;

public class StackArray2 {
  public static final int DEFAULT_INITIAL_SIZE = 100;
  private Object data[];

  private int top;
  private int size;

  public StackArray2() {
    data = new Object[DEFAULT_INITIAL_SIZE];
    top = 0;
    size = DEFAULT_INITIAL_SIZE;
  }

  public boolean isEmpty() {
    if (top == 0) {
      System.out.println(true);
      return true;
    }
    System.out.println(false);
    return false;
  }

  public void push(Object elem) {
    if (top == size) {
      growStack();
    }

    data[top] = elem;
    top++;
  }

  public Object pop() {
    if (top == 0) {
      System.out.println("stack is empty");
      return null;
    }
    top--;
    Object deleted = data[top];
    return deleted;
  }

  public void growStack() {
    Object[] newData = new Object[size * 2];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }

    data = newData;
    size = size * 2;
    System.out.println(size);
  }
}
