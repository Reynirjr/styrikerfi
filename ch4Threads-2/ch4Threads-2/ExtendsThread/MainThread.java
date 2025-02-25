package ch4Threads.ExtendsThread;

class MainThread {
  public static void main(String args[]) {
    Thread runner = new MyThread();
    runner.start();
    System.out.println("I Am The Main Thread");
  }
}
