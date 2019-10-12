package testNull;

import okhttp3.Request;

import java.util.Map;

/**
 * Created by Alina on 2019/9/26.
 */
public class NullCastToOtherObject {
  public static void main(String[] args) {
    System.out.println(nullCastToMap());
  }

  public static String nullCastToString() {
    String a = (String) null;
    return a;
  }

  public static Object nullCastToInteger() {
    Integer a = (Integer) null;
    return a;
  }

  public static Object nullCastToAnyOtherObject() {
    Request a = (Request) null;
    return a;
  }

  public static Object nullCastToMap() {
    Map a = (Map) null;
    return a;
  }
}
