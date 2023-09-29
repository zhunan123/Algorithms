package week6.thread.simpleThread;

import java.util.concurrent.*;

public class SolvingForMaxUsingExecutorService {

    public final static int NUM_ROWS = 10;

    // worker thread class
    private static class Worker implements Callable {
        // compute the max for each row then just return this max for each row
        double max = Double.MIN_VALUE;
        double[] row;

        public Worker(double[] row) {
            this.row = row;
        }

        @Override
        public Object call() {
            for (int i = 0; i < row.length; i++) {
                max = Math.max(max, row[i]);
            }
            // for Callable object that is different from Runnable, need to return a object
            return max;
        }
    }

    // main
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        double max = Double.MIN_VALUE;
        // create bigMatrix
        double [][] bigMatrix = generateBigMatrix(NUM_ROWS, 1000000);

        //using executorService and create pool of threads
        ExecutorService exec = Executors.newFixedThreadPool(NUM_ROWS);
        // Future Object is like placeholder, when computes a row sum, /
        // first the futureObject will reserve a spot for this row computed result
        // the main thread will not need to wait for this thread to finish then iterate to next threads
        // instead which this thread is executing to compute the max row element, the main thread will not wait this thread to finish
        // main thread will immediately go to next thread and assign task
        //once the previous thread is finsihed computing the row max, it will put the computed result in the Future object result array that is created just for this thread
        // so this way will be faster

        // create Future object array that has number of num_rows
        Future<Double>[] results = new Future[NUM_ROWS];
        for (int i = 0; i < NUM_ROWS; i++) {
            //actaully create thread to compute the each row max using executorService, and main thread do not need to wait for this thread to finish the task
            // main will create next thread and assign tasks, the previous thread can take time to compute the task,
            // but when previous thread finished computing, it will store the computed result in Future result array
            // which acts as a placeholder for this threads

            // thread will start to work
            Future<Double> res = exec.submit(new Worker(bigMatrix[i])); // this will return each row max value, and this max value will have Future<Double> type
            // store the computed result in Future result array
            results[i] = res;
        }

        // computing the bigger max for max of each row
        // this loop iterates over the results array,
        // calling the get method on each Future object to retrieve the result
        // of the computation performed by the corresponding Worker thread.
        for (int i = 0; i < NUM_ROWS; i++) {
            double val = results[i].get(); // will wait for the result to be ready, results[i] is each future object
            if (val > max)
                max = val;
        }


        exec.shutdown();// stop accepting any more new task but still will continue the current task
        exec.awaitTermination(1, TimeUnit.MINUTES);// will terminate a pool, but give a timeout to let current thread finish their task
    }

    public static double[][] generateBigMatrix(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Math.random();
                //System.out.print(matrix[row][col] + "\t");
            }
            //System.out.println();

        }
        return matrix;

    }
}
