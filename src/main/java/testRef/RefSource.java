package testRef;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alina on 2019/7/24.
 */
public class RefSource {
  public static void main(String[] args) {
    Map ref = new HashMap<>();
    ref = Source.getSource();
    System.out.println(ref);

    ref.put(2,2);
    System.out.println(ref);
    System.out.println(Source.getSource());


  }
}
