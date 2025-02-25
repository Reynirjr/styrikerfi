package ch4Threads.ParallelFibonacci;

public class FibonacciMultithreaded {

	public static void main(String[] args) {
		System.out.println("args.length="+args.length);
		if (args.length != 2) {
			System.out.println("Usage: FibonacciMultithreaded numberOfThreads MaximumFibbonaciNumber");
		} else {
			long numberOfThreads = Long.parseLong(args[0]);
			long limit = Long.parseLong(args[1]);
			for (long i = 0; i < numberOfThreads; i++) {
				FibonacciThread newThread = new FibonacciThread(i, numberOfThreads, limit);
				newThread.start();
			}
		}
	}
}
