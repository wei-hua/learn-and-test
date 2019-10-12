package mybaties.dao.impl;

import mybaties.dao.AffiliateDao;
import mybaties.dao.MyBatisUtil;
import mybaties.dao.mapper.AffiliateMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author siling
 * @Date 2017/7/10.
 */
public class AffiliateDaoImpl implements AffiliateDao {

  private AffiliateDaoImpl() {
  }

  private static AffiliateDao instance = new AffiliateDaoImpl();

  public static AffiliateDao getInstance() {
    return instance;
  }

  @Override
  public List<Map<String, Object>> queryTO(Set<Integer> affIds) {
    try (SqlSession sqlSession = MyBatisUtil.getSqlSession(true)) {
      AffiliateMapper affiliateMapper = sqlSession.getMapper(AffiliateMapper.class);
      return affiliateMapper.queryTO(affIds);
    }
  }

}
