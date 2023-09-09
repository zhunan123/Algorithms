package week3.immutableDesign.iterable;

import java.util.Iterator;

public class ToyBox implements Iterable<String>{
    private String[] toys;
    private int size;

    public ToyBox() {
        this.toys = new String[10];
        this.size = 0;
    }

    public ToyBox(String[] newToys) {
        this.toys = newToys;
        this.size = newToys.length;
    }

    public void addToy(String toy) {
        toys[size] = toy;
        size++;
    }


    @Override
    public ownIterator iterator() {
//        return toys.iterator() // cannot do this since regualr array do not have iterator() method
        // instead we can create our own Iterator class/object that implements the Iterator interface
        // return this new own iterator class instance
        ownIterator ownIt = new ownIterator();
        return ownIt;
    }

    public class ownIterator implements Iterator<String>{

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex < size && toys[currentIndex] != null) {
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            String nextToy = toys[currentIndex];
            currentIndex++;
            return nextToy;
        }
    }

    public static void main(String[] args) {
        ToyBox box = new ToyBox();
        box.addToy("t1");
        box.addToy("t2");
        box.addToy("t3");
        box.addToy("t4");

        Iterator<String> it = box.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
