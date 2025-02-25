package ch4Threads.Join;

class MainThread3 {
  public static void main(String[] args) {
    Thread runner = new JoinableThread();
    runner.start();
    try {
      runner.join();
    } catch (InterruptedException ie) { }
    System.out.println("Worker done");
  }
}
