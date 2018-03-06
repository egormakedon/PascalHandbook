package client.view;

import java.util.Observable;

public final class CurrentPage extends Observable {
    private static final CurrentPage INSTANCE = new CurrentPage();
    private CurrentPage() {}
    public static CurrentPage getInstance() {
        return INSTANCE;
    }

    private String currentTittle;
    private String currentBody;

    public void setCurrentTittle(String currentTittle) {
        this.currentTittle = currentTittle;
        super.setChanged();
        this.notifyObservers();
    }

    public void setCurrentBody(String currentBody) {
        this.currentBody = currentBody;
        super.setChanged();
        this.notifyObservers();
    }

    public String getCurrentTittle() {
        return currentTittle;
    }

    public String getCurrentBody() {
        return currentBody;
    }
}