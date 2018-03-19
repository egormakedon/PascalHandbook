package client.rpc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;

import java.util.List;

public class ControllerRPC {
    private static final Logger LOGGER = LogManager.getLogger(ControllerRPC.class);

    public List<String> takeTitles() {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            return client.takeTitles();
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }

    public String takeBody(String title) {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            return client.takeBody(title);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }

    public String deleteReference(String title) {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            return client.deleteReference(title);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }

    public String add(String title, String body) {
        Transport transport = new Transport();
        HandbookService.Client client = transport.getClient();

        try {
            return client.add(title, body);
        } catch (TException e) {
            LOGGER.log(Level.ERROR, e);
            throw new RuntimeException();
        } finally {
            transport.close();
        }
    }
}