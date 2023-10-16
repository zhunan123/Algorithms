package week8.customLocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeMap {
    /*
    Thread safe means when multiple thread call the same method, it won't run into the
    racing conditions, the result will be predictable.
    reading/accessing -> get() method, if we able to get the lock just go inside
    and access the map
    * */

    private Map<String, String> englishToSpanishMap;
    private ReentrantReadWriteLock lock;

    public ThreadSafeMap() {
        this.englishToSpanishMap = new HashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    public String getSpanishWord(String englishWord) {
        try {
            lock.readLock().lock();
            // once reader have the read lock, no other thread can obtain the write lock
            // until reader release read lock, writer and access write lock and modify it
            return englishToSpanishMap.get(englishWord);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addSpanishWord(String englishWord, String spanishWord) {
        try {
            lock.writeLock().lock();
            // after this line, writer need to check if there's reader, if yes need to wait til reader finishes reading
            // then will be granted the write lock and go inside block and write to it

            // here is writer wants to acquire write lock but finds out theres a 1 reader reading currently, so need to wait this readFunc() reader finishes and release the reader lock
            readFunc();
            englishToSpanishMap.put(englishWord, spanishWord);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void readFunc() {
        try {
            lock.readLock().lock();
            // read and get something here
        } finally {
            lock.readLock().unlock();
        }
    }
}
