package testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alina on 2019/5/11.
 */
public class deleteMap {
  public static void main(String[] args) {
    Map<String, Map<String, Object>> aaa = new HashMap<>();
    Map<String, Object> inner = new HashMap<>();
    inner.put("2","innerMap");
    aaa.put("1", inner);

    System.out.println(aaa);

    Map<String, Object> innerGot = aaa.get("1");
    aaa.remove("1");

    System.out.println(aaa);

    System.out.println(innerGot);

  }


}
