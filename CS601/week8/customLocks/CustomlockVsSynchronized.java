package week8.customLocks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CustomlockVsSynchronized {
    public class Counter {
        private int count = 0;
        public void increment() {
            synchronized (this) {
                count++;
            }
        }
    }

    public class Counter1 {
        private int count = 0;
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        public void increment() {
            try{
                lock.writeLock().lock();
                count++;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    /**
     when sb want to increment the count, first need to get access to it, lock.writeLock().lock();
     so what happen after writeLock.lock()? so this thread that is executing the increment() has to wait
     until it granted the write lock, so when will it be granted the write lock?
     when nobody is writing and nobody is reading
     if when current thread want to execute the increment(), there's another writer, so we have to wait on this line, it will be blocked on this line
     if nobody is reading and writing, this thread will be able to get the lock, go inside increment() and increment count;
     while its doing the work, nobody will be able to access to method
     once done will release the lock and other thread able to access into code block and increment count;
     * */
}
