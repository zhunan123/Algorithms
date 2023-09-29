package week6.thread.simpleThread;

public class SolvingForMax {
    // the inner class each thread class will find max in parallel within each row
    // but in outer class computes sequentially the bigger sum with each row,
    // main thread will need to wait each thread[i] to finish then call getMax and compare and update

    public final static int NUM_ROWS = 10;

    private static class WorkerThread extends Thread {
        double max = Double.MIN_VALUE;
        double[] row;

        public WorkerThread(double[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            for (int i = 0; i < row.length; i++) {
                max = Math.max(max, row[i]);
            }
        }

        public double getMax() {
            return max;
        }
    }

    public static void main(String[] args) {
        double [][] bigMatrix = generateBigMatrix(NUM_ROWS, 1000000);

        // create 10 worker thread
        // create WorkerThread array that contains 10 worker thread
        WorkerThread[] threads = new WorkerThread[bigMatrix.length];
        double max = Double.MIN_VALUE;

        //give each thread a row to compute the max
        for (int i = 0; i > NUM_ROWS; i++) {
            threads[i] = new WorkerThread(bigMatrix[i]);
            threads[i].start();
        }

        // main thread will wait till each thread to finish than computer the bigger max
        // then move to next iteration
        for(int i = 0; i < NUM_ROWS; i++) {
            try {
                threads[i].join();
                max = Math.max(max, threads[i].getMax());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static double[][] generateBigMatrix(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Math.random();
                // System.out.print(matrix[row][col] + "\t");
            }
            // System.out.println();

        }
        return matrix;

    }
}
