package client;

import java.util.ArrayList;
import java.util.List;

public final class Controller {
    private static final Controller INSTANCE = new Controller();
    private Controller() {}
    public static Controller getInstance() { return INSTANCE; }

    public List<String> takeHeaders() {
        //
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
    }

    public String takeBodyByHeader(String header) {
        //
        return "Lol";
    }
 }
