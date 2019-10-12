package testJava8;

/**
 * Created by Alina on 2018/7/30.
 */
public interface DefaultMethodIntereface {
  String messaee="qjeyrg";

  void sosmeMethod();
  default void defaultMethod(){
    System.out.println("default");
  }

  default void defaultMethod2(){
    System.out.println("default2");
  }
}
