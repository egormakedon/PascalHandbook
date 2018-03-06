package client.view;

public final class ServerType {
    private static final ServerType INSTANCE = new ServerType();
    private ServerType() {}
    public static ServerType getInstance() { return INSTANCE; }

    private Type serverType = Type.RPC;

    public enum Type {
        RPC, SOAP
    }

    public void changeServerType() {
        if (serverType == Type.RPC) {
            serverType = Type.SOAP;
        } else if (serverType == Type.SOAP) {
            serverType = Type.RPC;
        }
    }

    public Type getServerType() {
        return serverType;
    }
}