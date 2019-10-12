package mybaties.dao;

import mybaties.dao.impl.AffiliateDaoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alina on 2019/10/11.
 */
public class Main {
  public static void main(String[] args) {
    Set affiliateids = new HashSet();
    affiliateids.add(596);
    affiliateids.add(948);
    List<Map<String, Object>> TOMapList =
      AffiliateDaoImpl.getInstance().queryTO(affiliateids);
    System.out.println(TOMapList);
  }
}
