package client.model;

import java.util.Date;
import java.util.Observable;

public final class CurrentPage extends Observable {
    private static final CurrentPage INSTANCE = new CurrentPage();
    private CurrentPage() {}
    public static CurrentPage getInstance() {
        return INSTANCE;
    }

    private int articleId;
    private String title;
    private String body;
    private Date date = new Date();

    private int imageId;
    private String path;

    private int authorId;
    private String name;
    private String surname;
    private String country;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void reset() {
        articleId = 0;
        title = "";
        body = "";
        date.setTime(0);

        imageId = 0;
        path = "";

        authorId = 0;
        name = "";
        surname = "";
        country = "";
    }

    public void changeObserver() {
        super.setChanged();
        this.notifyObservers();
    }
}