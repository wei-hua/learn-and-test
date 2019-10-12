package testThreads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alina on 2019/9/30.
 */
public class ThreadYield {
  public static void main(String[] args) {
    for(int i=1; i<5;i++) {
      int num = i;
      Thread t = new Thread(()->{
        System.out.println(num);
        //without yield, the two statement will use the same cpu time in high probability
        //yield 只是让步，建议CPU调度其他线程，但最终结果并不能保证
        Thread.yield();
        System.out.println(num+":"+Thread.currentThread().getPriority());
      });
      t.start();
    }

    Thread.currentThread().setPriority(6); //the higher num thee higher priority
    System.out.println("main"+":"+Thread.currentThread().getPriority());
    System.out.println("finish");

  }
}
