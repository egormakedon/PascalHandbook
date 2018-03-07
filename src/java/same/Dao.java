package same;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Dao {
    private static final Logger LOGGER = LogManager.getLogger(Dao.class);
    private static final Dao INSTANCE = new Dao();
    private Dao() {}
    public static Dao getINSTANCE() {
        return INSTANCE;
    }

    private static final String TITLE = "title";
    private static final String BODY = "body";

    private static final String SQL_SELECT_ALL_TITLES = "SELECT title FROM article";
    private static final String SQL_SELECT_BODY_BY_TITLE = "SELECT body FROM article WHERE title=?";

    public List<String> takeTitles() {
        ProxyConnection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_TITLES);

            List<String> titles = new ArrayList<>();
            while (resultSet.next()) {
                String title = resultSet.getString(TITLE);
                titles.add(title);
            }
            return titles;
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }

    public String takeBody(String title) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BODY_BY_TITLE);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder body = new StringBuilder();
            while (resultSet.next()) {
                body.append(resultSet.getString(BODY));
            }
            return body.toString();
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
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
