package client.soap;

import by.makedon.axis.HandbookServiceStub;
import client.model.CurrentPage;
import org.apache.axis2.AxisFault;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ControllerSOAP {
    private static final Logger LOGGER = LogManager.getLogger(ControllerSOAP.class);
    private static final String URL = "http://localhost:8080/axis2/services/HandbookService";

    private HandbookServiceStub stub;

    public ControllerSOAP() {
        try {
            stub = new HandbookServiceStub(URL);
        } catch (AxisFault axisFault) {
            LOGGER.catching(axisFault);
        }
    }

    public String updateArticle(int id, String body) {
        HandbookServiceStub.UpdateArticle req = new HandbookServiceStub.UpdateArticle();
        HandbookServiceStub.Article article = new HandbookServiceStub.Article();
        article.setArticleId(id);
        article.setBody(body);
        req.setArgs0(article);
        HandbookServiceStub.UpdateArticleResponse resp = null;
        try {
            resp = stub.updateArticle(req);
        } catch (RemoteException e) {
            //
        }
        return resp.get_return();
    }

    public String deleteArticle(int id) {
        HandbookServiceStub.DeleteArticle req = new HandbookServiceStub.DeleteArticle();
        HandbookServiceStub.Article article = new HandbookServiceStub.Article();
        article.setArticleId(id);
        req.setArgs0(article);
        HandbookServiceStub.DeleteArticleResponse resp = null;
        try {
            resp = stub.deleteArticle(req);
        } catch (RemoteException e) {
            //
        }
        return resp.get_return();
    }

    public String add(String title, String body) {
        HandbookServiceStub.Add req = new HandbookServiceStub.Add();
        HandbookServiceStub.Article article = new HandbookServiceStub.Article();
        article.setTitle(title);
        article.setBody(body);
        req.setArgs0(article);
        HandbookServiceStub.AddResponse resp = null;
        try {
            resp = stub.add(req);
        } catch (RemoteException e) {
            //
        }
        return resp.get_return();
    }

    public List<String> takeArticleList() {
        HandbookServiceStub.TakeArticleList req = new HandbookServiceStub.TakeArticleList();
        HandbookServiceStub.TakeArticleListResponse resp = null;
        try {
            resp = stub.takeArticleList(req);
        } catch (RemoteException e) {
            //
        }
        HandbookServiceStub.Article[] articles = resp.get_return();
        List<String> titles = new ArrayList<String>();
        for (int index = 0; index < articles.length; index++) {
            titles.add(articles[index].getTitle());
        }
        return titles;
    }

    public void takeArticle(String title) {
        HandbookServiceStub.TakeArticle req = new HandbookServiceStub.TakeArticle();
        req.setArgs0(title);
        HandbookServiceStub.TakeArticleResponse resp = null;
        try {
            resp = stub.takeArticle(req);
        } catch (RemoteException e) {
            //
        }
        HandbookServiceStub.Article article = resp.get_return();

        CurrentPage currentPage = CurrentPage.getInstance();

        currentPage.setArticleId(article.getArticleId());
        currentPage.setTitle(article.getTitle());
        currentPage.setBody(article.getBody());
        currentPage.setDate(article.getDate());
        currentPage.setImageId(article.getImage().getImageId());
        currentPage.setPath(article.getImage().getPath());
        currentPage.setAuthorId(article.getAuthor().getAuthorId());
        currentPage.setName(article.getAuthor().getName());
        currentPage.setSurname(article.getAuthor().getSurname());
        currentPage.setCountry(article.getAuthor().getCountry());
    }
}
