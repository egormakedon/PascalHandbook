package client;

import client.rpc.ControllerRPC;
import client.soap.ControllerSOAP;
import client.view.ServerType;

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

    public String takeBody(String title) {
        String body = null;

        if (getServerType() == ServerType.Type.RPC) {
            body = controllerRPC.takeBody(title);
        } else if (getServerType() == ServerType.Type.SOAP) {
            // code
        }

        return body;
    }

    private ServerType.Type getServerType() {
        return ServerType.getInstance().getServerType();
    }
 }