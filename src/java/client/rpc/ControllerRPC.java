package client.rpc;

import client.model.CurrentPage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;
import rpcserver.thrift.Article;
import rpcserver.thrift.HandbookService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerRPC {
    private static final Logger LOGGER = LogManager.getLogger(ControllerRPC.class);

    public List<String> takeTitles() {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            List<Article> articleList = client.takeArticleList();
            List<String> titleList = new ArrayList<String>();
            for (Article article : articleList) {
                titleList.add(article.getTitle());
            }
            return titleList;
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }
    public void takeArticle(String title) {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            Article article = client.takeArticle(title);
            CurrentPage currentPage = CurrentPage.getInstance();

            currentPage.setArticleId(article.getArticleId());
            currentPage.setTitle(article.getTitle());
            currentPage.setBody(article.getBody());
            currentPage.setDate(new Date(article.getDate().year, article.getDate().month, article.getDate().day));
            currentPage.setImageId(article.getImage().imageId);
            currentPage.setPath(article.getImage().path);
            currentPage.setAuthorId(article.getAuthor().authorId);
            currentPage.setName(article.getAuthor().name);
            currentPage.setSurname(article.getAuthor().surname);
            currentPage.setCountry(article.getAuthor().country);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }
    public String addArticle(String title, String body) {
        Article article = new Article();
        article.setTitle(title);
        article.setBody(body);

        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        String result;
        try {
            result = client.add(article);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
        return result;
    }
    public String deleteArticle(int id) {
        Article article = new Article();
        article.setArticleId(id);

        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        String result;
        try {
            result = client.deleteArticle(article);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
        return result;
    }
    public String updateArticle(int id, String body) {
        Article article = new Article();
        article.setArticleId(id);
        article.setBody(body);

        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        String result;
        try {
            result = client.updateArticle(article);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
        return result;
    }
}