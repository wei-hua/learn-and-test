package mybaties.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author siling
 * @Date 2017/6/12.
 */
public class MyBatisUtil {

  public static SqlSession getSqlSession(boolean autoCommit) {
    return getSqlSessionFactory().openSession(autoCommit);
  }

  private static SqlSessionFactory getSqlSessionFactory() {
    String resource = "/mybatis-conf.xml";
    InputStream is = MyBatisUtil.class.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(is);
  }

  public static <T> T execute(String className, String methodName, Class<?> parameterTypes,
      Class T) {

    SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
    Object obj = null;
    try {
      obj = sqlSession.getMapper(Class.forName(className));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Method method = null;
    try {
      method = obj.getClass().getMethod(methodName, parameterTypes);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    try {
      T t = (T) method.invoke(obj, parameterTypes);
      return t;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

}