package rpcserver;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import same.HandbookService;
import same.ServerhostProperties;

class Server {
    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    public void start() {
        try {
            HandbookHandler handler = new HandbookHandler();
            HandbookService.Processor processor = new HandbookService.Processor(handler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    private void simple(HandbookService.Processor processor) {
        try {
            int port = ServerhostProperties.getINSTANCE().getPort();
            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            server.serve();
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
