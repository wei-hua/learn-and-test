package mybaties.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author siling
 * @Date 2017/7/10.
 */
public interface AffiliateDao {
  List<Map<String, Object>> queryTO(Set<Integer> affIds);
}
