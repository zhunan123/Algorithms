package CS545.week6.stack;

public class BuildStackinArray1 {

    public static final int DEFAULT_INITIAL_SIZE = 100;
    private Object[] data;

    private int top; //top is the index of element right after the element at the top of stack
    private int size;

    public BuildStackinArray1() {
        data = new Object[DEFAULT_INITIAL_SIZE];
        top = 0;
        size = DEFAULT_INITIAL_SIZE;
    }

    public boolean empty() {
        return top == 0;
    }

    public void push(Object elem) {
        if (top == size) {
            growStack();
        }

        data[top] = elem;
        top++;
    }

    public Object pop() {
        Object elem;
        if (top > 0) {
            top--;
            elem = data[top];
        } else {
            return null;
        }
        return elem;
    }


    protected void growStack() {
        Object[] newData = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = size * 2;
    }
}
