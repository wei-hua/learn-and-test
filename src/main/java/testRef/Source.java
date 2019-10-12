package testRef;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alina on 2019/7/24.
 */
public class Source {
  static Map sourceData = new HashMap();

  public static Map getSource() {
    sourceData.put(1,1);
    return sourceData;
  }
}
