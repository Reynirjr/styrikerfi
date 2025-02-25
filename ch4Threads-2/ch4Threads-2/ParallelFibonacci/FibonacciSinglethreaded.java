package ch4Threads.ParallelFibonacci;

public class FibonacciSinglethreaded {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: FibonacciSinglethreaded MaximumFibbonaciNumber");
		} else {
			long limit = Long.parseLong(args[0]);
			long fiboResult;
			for (long i = 0; i <= limit; i = i + 1) {
				System.out.println("Working on fibo(" + i + ")...");
				fiboResult = FibonacciMath.fibo(i);
				System.out.println("... fibo(" + i + ")=" + fiboResult);
			}
		}
	}
}
