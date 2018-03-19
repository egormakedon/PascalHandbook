package same;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rpcserver.thrift.Article;
import rpcserver.thrift.Author;
import rpcserver.thrift.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Dao {
    private static final Logger LOGGER = LogManager.getLogger(Dao.class);
    private static final Dao INSTANCE = new Dao();
    private Dao() {}
    public static Dao getInstance() {
        return INSTANCE;
    }

    private static final String SQL_UPDATE_ARTICLE = "UPDATE article SET body=? WHERE article_id=?";
    private static final String SQL_DELETE_ARTICLE = "DELETE FROM article WHERE article_id=?";
    private static final String SQL_ADD_ARTICLE = "INSERT INTO article(title,body,date,fk_image_id,fk_author_id) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ALL_ARTICLES = "SELECT article_id,title,body,date,fk_image_id,fk_author_id," +
            "path,name,surname,country FROM article INNER JOIN image ON fk_image_id=image_id " +
            "INNER JOIN author ON fk_author_id=author_id";
    private static final String SQL_SELECT_ARTICLE_BY_TITLE = "SELECT article_id,title,body,date,fk_image_id,fk_author_id," +
            "path,name,surname,country FROM article INNER JOIN image ON fk_image_id=image_id " +
            "INNER JOIN author ON fk_author_id=author_id WHERE title=?";

    public boolean updateArticle(Article article) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_ARTICLE);
            int articleId = article.getArticleId();
            String body = article.getBody();
            statement.setString(1, body);
            statement.setInt(2, articleId);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }
    public boolean deleteArticle(Article article) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_DELETE_ARTICLE);
            int articleId = article.getArticleId();
            statement.setInt(1, articleId);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }
    public boolean addArticle(Article article) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_ADD_ARTICLE);

            String title = article.getTitle();
            String body = article.getBody();
            int year = article.getDate().getYear();
            int day = article.getDate().getDay();
            int month = article.getDate().getMonth();
            Date date = new Date((long)(year*365*24*60*60*1000 + month*30*24*60*60*1000 + day*24*60*60*1000));
            int fk_image_id = 1;
            int fk_author_id = 1;

            statement.setString(1, title);
            statement.setString(2, body);
            statement.setDate(3, date);
            statement.setInt(4, fk_image_id);
            statement.setInt(5, fk_author_id);

            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }
    public List<Article> takeArticleList() {
        List<Article> articleList = new ArrayList<Article>();
        ProxyConnection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ARTICLES);
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("article_id"));
                article.setTitle(resultSet.getString("title"));
                article.setBody(resultSet.getString("body"));

                Date date = resultSet.getDate("date");
                rpcserver.thrift.Date thriftDate = new rpcserver.thrift.Date();
                thriftDate.setYear(date.getYear());
                thriftDate.setDay(date.getDay());
                thriftDate.setMonth(date.getMonth());
                article.setDate(thriftDate);

                Image image = new Image();
                image.setImageId(resultSet.getInt("fk_image_id"));
                image.setPath(resultSet.getString("path"));
                article.setImage(image);

                Author author = new Author();
                author.setAuthorId(resultSet.getInt("fk_author_id"));
                author.setName(resultSet.getString("name"));
                author.setSurname(resultSet.getString("surname"));
                author.setCountry(resultSet.getString("country"));
                article.setAuthor(author);

                articleList.add(article);
            }
            return articleList;
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }
    public Article takeArticle(String title) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ARTICLE_BY_TITLE);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            Article article = new Article();
            article.setArticleId(resultSet.getInt("article_id"));
            article.setTitle(resultSet.getString("title"));
            article.setBody(resultSet.getString("body"));

            Date date = resultSet.getDate("date");
            rpcserver.thrift.Date thriftDate = new rpcserver.thrift.Date();
            thriftDate.setYear(date.getYear());
            thriftDate.setDay(date.getDay());
            thriftDate.setMonth(date.getMonth());
            article.setDate(thriftDate);

            Image image = new Image();
            image.setImageId(resultSet.getInt("fk_image_id"));
            image.setPath(resultSet.getString("path"));
            article.setImage(image);

            Author author = new Author();
            author.setAuthorId(resultSet.getInt("fk_author_id"));
            author.setName(resultSet.getString("name"));
            author.setSurname(resultSet.getString("surname"));
            author.setCountry(resultSet.getString("country"));
            article.setAuthor(author);

            return article;
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
