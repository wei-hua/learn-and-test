package testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * when putall's arg is null, it will throw nullPoint exception
 */
public class putAllNull {
  public static void main(String[] args) {
    Map aa = new HashMap();
    aa.put(1,2);
    aa.putAll(null);
    System.out.print(aa);
  }

}
