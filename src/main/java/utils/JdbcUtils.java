package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qiuyang
 * @date 2018-10-31 01:16
 * JDBC 操作的工具类主要负责
 * 1.获取连接的方法
 * 2.释放的方法
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

//    静态代码块只被执行一次
    static {
        dataSource =new ComboPooledDataSource("mvcapp");
        //对应c3p0-config.xml里的<named-config name="mvcapp">
    }


    /**
     * @return
     * 释放Connection的
     */
    public static void releaseConnection(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @return
     * 获取连接的方法
     * 返回一个数据源的Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
