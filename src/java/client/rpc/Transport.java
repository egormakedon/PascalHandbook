package client.rpc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import same.HandbookService;
import same.ServerhostProperties;

class Transport {
    private static final Logger LOGGER = LogManager.getLogger(Transport.class);

    private TTransport transport;
    private HandbookService.Client client;

    Transport() {
        String host = ServerhostProperties.getINSTANCE().getHost();
        int port = ServerhostProperties.getINSTANCE().getPort();

        try {
            transport = new TSocket(host, port);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            client = new HandbookService.Client(protocol);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public HandbookService.Client getClient() {
        return client;
    }

    public void close() {
        if (transport != null) {
            transport.close();
        }
    }
}