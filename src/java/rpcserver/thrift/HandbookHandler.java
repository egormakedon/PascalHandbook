package rpcserver.thrift;

import org.apache.thrift.TException;
import same.Dao;

import java.util.List;

public class HandbookHandler implements HandbookService.Iface {
    @Override
    public String updateArticle(Article article) throws TException {
        if (Dao.getInstance().updateArticle(article)) {
            return "update article successfully";
        } else {
            return "wrong update";
        }
    }

    @Override
    public String deleteArticle(Article article) throws TException {
        if (Dao.getInstance().deleteArticle(article)) {
            return "delete article successfully";
        } else {
            return "wrong delete";
        }
    }

    @Override
    public String add(Article article) throws TException {
        if (Dao.getInstance().addArticle(article)) {
            return "add article successfully";
        } else {
            return "wrong add";
        }
    }

    @Override
    public List<Article> takeArticleList() throws TException {
        return Dao.getInstance().takeArticleList();
    }

    @Override
    public Article takeArticle(String title) throws TException {
        return Dao.getInstance().takeArticle(title);
    }
}
