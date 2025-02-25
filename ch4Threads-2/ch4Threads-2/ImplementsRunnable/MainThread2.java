package ch4Threads.ImplementsRunnable;

class MainThread2 {
   public static void main(String args[]) {
      Runnable runner = new MyThread2();
      Thread thread = new Thread(runner);
      thread.start();
      System.out.println("I Am The Main Thread");
   }
}
