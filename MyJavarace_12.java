// You are free to modify this class, e.g. add fields, methods,
// constructors, extend from class Thread etc. with these two exceptions:
// 1. Do not change the name of this class nor put it into another package
// 2. Do not modify the name and input/output parameter of the main method.

public class MyJavarace_12 {

    private static volatile long in = 0;            
    private static volatile boolean[] flag = new boolean[2];
    private static volatile int turn;

    public static long main(long iterationsPerThread) { 
        
        in = 0;
        flag[0] = false;
        flag[1] = false;
        turn = 0;

        Thread t0 = new Thread(new PetersonIncrement(0, iterationsPerThread));
        Thread t1 = new Thread(new PetersonIncrement(1, iterationsPerThread));

        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return in;
    }

    private static class PetersonIncrement implements Runnable {
        private final int i;  
        private final int j;   
        private final long iterations;

        public PetersonIncrement(int threadId, long iterationsPerThread) {
            this.i = threadId;
            this.j = 1 - threadId;  
            this.iterations = iterationsPerThread;
        }

        @Override
        public void run() {
            for (long k = 0; k < iterations; k++) {
                flag[i] = true;
                turn = j;
                while (flag[j] && turn == j) {
                }

                in++;

                flag[i] = false;
            }
        }
    }
}
