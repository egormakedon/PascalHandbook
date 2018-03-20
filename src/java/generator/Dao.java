package generator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rpcserver.dao.ConnectionPool;
import rpcserver.dao.ProxyConnection;

import java.sql.*;
import java.util.Map;

final class Dao {
    private static final Logger LOGGER = LogManager.getLogger(Dao.class);
    private static final Dao INSTANCE = new Dao();
    private Dao() {}
    public static Dao getInstance() { return INSTANCE; }

    private static final String SQL_INSERT_IMAGE = "INSERT INTO image(path) VALUES(?)";
    private static final String SQL_SELECT_LAST_IMAGE = "SELECT * FROM image ORDER BY image_id DESC LIMIT 1";
    private static final String SQL_INSERT_AUTHOR = "INSERT INTO author(name,surname,country) VALUES(?,?,?)";
    private static final String SQL_SELECT_LAST_AUTHOR = "SELECT * FROM author ORDER BY author_id DESC LIMIT 1";
    private static final String SQL_INSERT_ARTICLE = "INSERT INTO article(title,body,date,fk_image_id,fk_author_id) VALUES(?,?,?,?,?)";

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
    public int addAuthor(Map<String, String> parameters) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        Statement st = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_INSERT_AUTHOR);

            String name = parameters.get("name");
            String surname = parameters.get("surname");
            String country = parameters.get("country");

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, country);
            statement.executeUpdate();

            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_LAST_AUTHOR);
            resultSet.next();
            return resultSet.getInt("author_id");
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(st);
            close(statement);
            close(connection);
        }
    }
    public void addArticle(Map<String, Object> parameters) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_INSERT_ARTICLE);

            String title = (String) parameters.get("title");
            String body = (String) parameters.get("body");
            Date date = (Date) parameters.get("date");
            int image_id = (int) parameters.get("image_id");
            int author_id = (int) parameters.get("author_id");

            statement.setString(1, title);
            statement.setString(2, body);
            statement.setDate(3, date);
            statement.setInt(4, image_id);
            statement.setInt(5, author_id);

            statement.executeUpdate();
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
