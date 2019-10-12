package mybaties.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author siling
 * @Date 2017/7/10.
 */
public interface AffiliateMapper {

  List<Map<String, Object>> queryTO(@Param("affIds") Set<Integer> affIds);
}
