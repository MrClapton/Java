package NetworkServer.chat.Database;

import java.sql.*;

public class SQLite implements JDBC {
    private static final String CONN_URL = "jdbc:sqlite:chat.db";
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private Connection connection;
    private Statement statement;

    public SQLite() {
        connect();
        initTables();
        close();
    }

    @Override
    public ResultSet select(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    @Override
    public int update(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    @Override
    public int insert(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    @Override
    public int delete(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    @Override
    public void connect() {
        try {
            Class.forName(CLASS_NAME);
            connection = DriverManager.getConnection(CONN_URL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            if (statement != null && !statement.isClosed())
                statement.close();
            if (connection!= null && !connection.isClosed())
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initTables() {
        if (statement != null) {
            try {
                statement.execute("" +
                        "CREATE TABLE if not exists 'users' (" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "'username' VARCHAR(50), " +
                        "'login' VARCHAR(50), " +
                        "'password' VARCHAR(50))");

                ResultSet resultSet = statement.executeQuery("SELECT count(*) AS cnt FROM users");
                if (resultSet.getInt("cnt") == 0) {
                    statement.execute("" +
                            "INSERT INTO users ('username', 'login', 'password')" +
                            "VALUES ('Oleg', 'login1', 'pass1')");
                    statement.execute("" +
                            "INSERT INTO users ('username', 'login', 'password')" +
                            "VALUES ('Alexey', 'login2', 'pass2')");
                    statement.execute("" +
                            "INSERT INTO users ('username', 'login', 'password')" +
                            "VALUES ('Peter', 'login3', 'pass3')");
                }
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
