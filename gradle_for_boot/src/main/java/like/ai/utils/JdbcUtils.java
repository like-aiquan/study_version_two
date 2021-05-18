package like.ai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @author by chenaiquan<like.aiquan@qq.com>  create on 2021/5/11 21.07
 */
public class JdbcUtils {

  private static DataSource dataSource;

  static {
    Properties properties = new Properties();
    try {
      properties.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
      dataSource = DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(JdbcUtils.getConnection());
  }

}
