package client;

import client.rpc.ControllerRPC;
import client.soap.ControllerSOAP;
import client.model.ServerType;

import java.util.List;

public final class Controller {
    private static final Controller INSTANCE = new Controller();
    private Controller() {}
    public static Controller getInstance() { return INSTANCE; }

    private ControllerRPC controllerRPC = new ControllerRPC();
    private ControllerSOAP controllerSOAP = new ControllerSOAP();

    public List<String> takeTitles() {
        List<String> result = null;

        if (getServerType() == ServerType.Type.RPC) {
            result = controllerRPC.takeTitles();
        } else if (getServerType() == ServerType.Type.SOAP) {
            result = controllerSOAP.takeArticleList();
        }

        return result;
    }
    public void takeArticle(String title) {
        if (getServerType() == ServerType.Type.RPC) {
            controllerRPC.takeArticle(title);
        } else if (getServerType() == ServerType.Type.SOAP) {
            controllerSOAP.takeArticle(title);
        }
    }
    public String add(String title, String body) {
        String result = null;
        if (getServerType() == ServerType.Type.RPC) {
            result = controllerRPC.addArticle(title, body);
        } else if (getServerType() == ServerType.Type.SOAP) {
            result = controllerSOAP.add(title, body);
        }
        return result;
    }
    public String delete(int id) {
        String result = null;
        if (getServerType() == ServerType.Type.RPC) {
            result = controllerRPC.deleteArticle(id);
        } else if (getServerType() == ServerType.Type.SOAP) {
            result = controllerSOAP.deleteArticle(id);
        }
        return result;
    }
    public String update(int id, String body) {
        String result = null;
        if (getServerType() == ServerType.Type.RPC) {
            result = controllerRPC.updateArticle(id, body);
        } else if (getServerType() == ServerType.Type.SOAP) {
            result = controllerSOAP.updateArticle(id, body);
        }
        return result;
    }

    private ServerType.Type getServerType() {
        return ServerType.getInstance().getServerType();
    }
 }