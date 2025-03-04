package Assignment11;
// You are free to modify this class, e.g. add fields, methods,
// constructors, extend from class Thread etc. with the two exceptions:
// 1. Do not change the name of this class nor put it into another package
// 2. Do not modify the name and input/output parameter of the main method.

public class MyJavarace_11 {


    private static volatile long in = 0;

    public static long main(long iterationsPerThread) { 

        in = 0;

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < iterationsPerThread; i++) {    
                long next_free_slot = in;
                next_free_slot++;
                in = next_free_slot;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < iterationsPerThread; i++) {
                long next_free_slot = in;
                next_free_slot++;
                in = next_free_slot;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return in;
    }
}
