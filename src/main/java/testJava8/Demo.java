package testJava8;

/**
 * Created by Alina on 2018/7/30.
 */
public class Demo {


  public static void main(String[] args) {
    DefaultMethodIntereface defaultMethodIntereface = () -> System.out.println("invok");
    defaultMethodIntereface.sosmeMethod();
  }
}
