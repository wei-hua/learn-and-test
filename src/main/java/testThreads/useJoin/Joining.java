package testThreads.useJoin;

/**
 * Created by Alina on 2019/9/30.
 */
public class Joining {
  public static void main(String[] args) {
    Sleeper
      sleepy = new Sleeper(15000, "Sleepy"),
      grumpy = new Sleeper(15000, "grumpy");

    Joiner
      dopey  = new Joiner("doepy", sleepy),
      doc = new Joiner("doc", grumpy);
    grumpy.interrupt();
  }
}
