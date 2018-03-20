package rpcserver;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public final class ServerhostProperties {
    private static final ServerhostProperties INSTANCE = new ServerhostProperties();
    private ServerhostProperties() {
        set();
    }
    public static ServerhostProperties getINSTANCE() {
        return INSTANCE;
    }

    private static final Logger LOGGER = LogManager.getLogger(ServerhostProperties.class);
    private static final String SERVERHOST_PROPERTY_PATH = "/property/serverhost.properties";

    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    private void set() {
        URL url = this.getClass().getResource(SERVERHOST_PROPERTY_PATH);
        if (url == null) {
            LOGGER.log(Level.FATAL, "serverhost property hasn't found");
            throw new RuntimeException();
        }

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(url.toURI())));
        } catch (URISyntaxException | IOException e) {
            LOGGER.log(Level.ERROR, e);
        }

        host = properties.getProperty("serverhost.ip");
        port = Integer.parseInt(properties.getProperty("serverhost.port"));
    }
}
