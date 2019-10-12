package testThreads.useJoin;

/**
 * Created by Alina on 2019/9/30.
 */
public class Sleeper extends Thread {
  private int duration;

  public Sleeper(int duration, String name) {
    super(name);
    duration = duration;
    start();
  }

  @Override
  public void run() {
    try {
      sleep(duration);
    } catch (InterruptedException e) {
      System.out.println(getName()+" was interrupted" + "isInterrupted():" + isInterrupted());
      return;
    }
    System.out.println(getName()+ "has awakened");
  }
}
