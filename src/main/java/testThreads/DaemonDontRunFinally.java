package testThreads;

import java.util.concurrent.TimeUnit;

/**
 * 一旦一个非守护线程终止，则守护线程会立即终止
 */
public class DaemonDontRunFinally {

  public static void main(String[] args) {
    DaemonDontRunFinally outer = new DaemonDontRunFinally();
    ADaemon inner = outer.new ADaemon();
    Thread t = new Thread(inner);
    //如果注释掉下面这行，则finally块可以执行
    t.setDaemon(true);
    //start 一定要在setDaemon之后
    t.start();
  }


  class ADaemon implements Runnable{
    @Override
    public void run() {
      System.out.println("daemon stared");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("finally statement has been executed");
      }
    }
  }


}
