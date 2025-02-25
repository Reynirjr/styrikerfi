package ch4Threads.ParallelFibonacci;

public class FibonacciThread extends Thread {

	private long theStart;
	private long theIncrement;
	private long theLimit;

	public FibonacciThread(long start, long increment, long limit) {
		theStart = start;
		theIncrement = increment;
		theLimit = limit;
	}

	@Override
	public void run() {
		System.out.println("Thread " + theStart + " start");
		long fiboResult;
		for (long i = theStart; i <= theLimit; i = i + theIncrement) {
			System.out.println("Thread " + theStart + ": working on fibo(" + i + ")...");
			fiboResult = FibonacciMath.fibo(i);
			System.out.println("...Thread " + theStart + ": fibo(" + i + ")=" + fiboResult);
		}
		System.out.println("Thread " + theStart + " finish");

	}

	
}
