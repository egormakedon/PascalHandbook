package generator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import same.ConnectionPool;
import same.ProxyConnection;

import java.sql.*;

final class Dao {
    private static final Logger LOGGER = LogManager.getLogger(Dao.class);
    private static final Dao INSTANCE = new Dao();
    private Dao() {}
    public static Dao getInstance() { return INSTANCE; }

    private static final String SQL_INSERT_IMAGE = "INSERT INTO image(path) VALUES(?)";
    private static final String SQL_SELECT_LAST_IMAGE = "SELECT * FROM image ORDER BY image_id DESC LIMIT 1";

    public int addImage(String path) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        Statement st = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_INSERT_IMAGE);
            statement.setString(1, path);
            statement.executeUpdate();

            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_LAST_IMAGE);
            resultSet.next();
            return resultSet.getInt("image_id");
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(st);
            close(statement);
            close(connection);
        }
    }

    private void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }
    private void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }
}
