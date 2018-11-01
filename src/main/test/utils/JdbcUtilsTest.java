package utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsTest {

    @Test
    public void releaseConnection() {
    }

    @Test
    public void getConnection() throws SQLException {
        Connection connection =JdbcUtils.getConnection();
        System.out.println(connection);
    }
}