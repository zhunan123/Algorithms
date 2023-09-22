package week5.nestedClass.staticNestedClass;

public class MyMap {

    // in what case is static nested class needed?
    /**
     when you need a helper function that is closely related to the outer function
     but do not need to access outer class's non-static member variables or method, then you
     can make this helper method static nested

     put method will add the key and value pair into MyEntry
     Each instance of MyEntry represents an entry in the hash table with a key and value pair.
     hashtable is [] with MyEntry pairs inside, MyEntry consist of key value pairs

     also static class do not need to instantiate outer class
     * */

    private MyEntry[] hashtable;
    private int maxSize;

    public MyMap(int maxSize) {
        hashtable = new MyEntry[maxSize];
        this.maxSize = maxSize;
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = null;
        }
    }

    /* MyEntry is a static nested class inSide MyMap to help to store all hashmap entry pairs
    no access modifier means is package private
    */
    static class MyEntry {
        private String key;
        private Object value;

        public MyEntry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    // added hashmap related put get method
    public void put(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        MyEntry entry = new MyEntry(key, value);
        int index = hash(key);
        int originalIndex = index;

        while (hashtable[index] != null && (!hashtable[index].getKey().equals(key))) {
            index = (index + 1) % maxSize;
            if (index == originalIndex) {
                System.out.println("table is full");
                return;
            }
        }
        hashtable[index] = entry;
    }

    public Object get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        while (hashtable[index] != null && !hashtable[index].getKey().equals(key)) {
            index = (index + 1) % maxSize;
        }
        return hashtable[index].getValue();
    }

    public int hash(String key) {
        return key.hashCode() % maxSize;
    }

    public static void main(String[] args) {
        MyMap map = new MyMap(10);
        map.put("Hello", 3);
        System.out.println(map.get("Hello"));

        // entry is separated from map, almost a different function, so inside entry not able to access hashmap details
        MyEntry entry = new MyEntry("jack", 10);
        System.out.println(entry.getValue());
    }
}
