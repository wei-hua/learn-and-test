package testNull;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLSyntaxErrorException;

/**
 * Created by Alina on 2019/9/27.
 */
public class NullToJson {
  private static ObjectMapper mapper = new ObjectMapper();

  public static String toJSONString(Object object) {
    String json = null;
    try {
      json = mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      System.out.println();
    }
    return json;
  }

  public static void main(String[] args) {
    String a = toJSONString(null);
    System.out.println(a);
  }

}
