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
            // code
        }

        return result;
    }

    public void takeArticle(String title) {
        if (getServerType() == ServerType.Type.RPC) {
            controllerRPC.takeArticle(title);
        } else if (getServerType() == ServerType.Type.SOAP) {
            // code
        }
    }

    private ServerType.Type getServerType() {
        return ServerType.getInstance().getServerType();
    }
 }