package testThreads.useJoin;

/**
 * Created by Alina on 2019/9/30.
 */
public class Joiner extends Thread {
  private Sleeper sleeper;
  public Joiner(String name, Sleeper sleeper) {
    super(name);
    this.sleeper = sleeper;
    start();
  }

  @Override
  public void run() {
    try {
      //仅当sleeper运行结束才会继续运行下面的语句
      sleeper.join();
    } catch (InterruptedException e) {
      System.out.println(getName()+ "interrupted");
    }
    System.out.println(getName()+ " join completed");
  }
}
