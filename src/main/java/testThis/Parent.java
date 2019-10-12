package testThis;

/**
 * Created by Alina on 2019/3/11.
 */
public abstract class Parent {
  int num;

  public void setNum(int num) {
    this.num = num;
  }

  public void printAtrribute() {
    System.out.print(this.num);
  }
}
