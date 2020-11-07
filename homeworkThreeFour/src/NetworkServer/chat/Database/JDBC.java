package NetworkServer.chat.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface JDBC {
    ResultSet select(String sql) throws SQLException;

    int update(String sql) throws SQLException;

    int insert(String sql) throws SQLException;

    int delete(String sql) throws SQLException;

    void connect();

    void close();
}
