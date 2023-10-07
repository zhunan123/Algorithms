package week3.designPattern.cohesion;

public class Stack {
    // this stack class is high cohesion, very clear task, each variable is working together on the main task

    final static int MAX_SIZE = 20;
    private Object[] data;
    private int top = 0;

    public Stack() {
        data = new Object[MAX_SIZE];
        top = 0;
    }

    public void push(Object elem) {
        if (top == MAX_SIZE)
            throw new IllegalStateException();
        data[top] = elem;
        top++;

    }
    public Object pop() {
        return data[--top];
    }
    public boolean empty() {
        return (top == 0);
    }
}
