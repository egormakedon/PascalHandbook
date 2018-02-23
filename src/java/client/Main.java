package client;

import client.view.CurrentPage;
import client.view.Frame;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        CurrentPage.getInstance().addObserver(frame);
        frame.show();
    }
}