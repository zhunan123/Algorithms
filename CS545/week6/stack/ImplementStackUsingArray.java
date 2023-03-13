package CS545.week6.stack;

public class ImplementStackUsingArray {
    /**
     * in this method we are using top as the element after the top element
     * so push is first data[top] then top++, pop is first decrement top, then delete top
     *
     * but more general case is top is the element as top
     * end of arraylist is the top of stack
     * stack array push——> first increment top, then add element at position top
     * stack array pop ———>first delete elemet at postion of top,  then decrement the top
     * */

    public static final int DEFAULT_INITIAL_SIZE = 100;
    private Object data[];

    private int top; //top is the index of element right after the element at the top of stack
    private int size;

    public ImplementStackUsingArray() {
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
        /* equals to data[top++] */
        //first data[top] then top++
        data[top] = elem;
        top++;
    }

    public Object pop() {
        Object elem;
        if (top > 0) {
            //data[--top] --->  first decrement top, then delete top
            top--;
            elem = data[top];
        } else {
            return null;
        }
        return elem;
    }


    protected void growStack() {
        int i;
        Object newData[];

        newData = new Object[size * 2];
        for (i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = size * 2;
    }
}
