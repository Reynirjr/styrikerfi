// You are free to modify this class, e.g. add fields, methods,
// constructors, extend from class Thread etc. with the two exceptions:
// 1. Do not change the name of this class nor put it into another package
// 2. Do not modify the name and input and output parameter of the main method.

import java.util.concurrent.Semaphore;

public class MyJavarace_14 extends Thread {
	private static long theNumberOfIterations;
	private volatile static long in;

	private static Semaphore mutex = new Semaphore(1);

	public static long main(long iterationsPerThread) {
		in = 0;
		theNumberOfIterations = iterationsPerThread;

		MyJavarace_14 raceDemo0 = new MyJavarace_14();
		MyJavarace_14 raceDemo1 = new MyJavarace_14();

		raceDemo0.setName("0");
		raceDemo1.setName("1");

		raceDemo0.start();
		raceDemo1.start();

		try {
			raceDemo0.join();
			raceDemo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		return in;
	}
		
	@Override
	public void run() {
		for (long i = 0; i < MyJavarace_14.theNumberOfIterations; i++) {
			this.increment();
		}
	}

	public void increment() {

		try {
			mutex.acquire();

			System.err.println("Thread " + Thread.currentThread().getName());

			long next_free_slot = in;
			next_free_slot = next_free_slot + 1;
			in = next_free_slot;

		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
		} finally {
			mutex.release();
		}
	}
}
