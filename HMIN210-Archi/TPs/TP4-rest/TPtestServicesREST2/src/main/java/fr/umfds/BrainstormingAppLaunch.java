package fr.umfds;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Level;

public class BrainstormingAppLaunch {
    public static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        // ici choisissez l'adresse à laquelle vous rendez accessible votre API, ainsi que le numéro de port;
        return UriBuilder.fromUri("http://localhost/rest").port(8080).build();
    }

    public static void main(String[] args) {
        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(BrainstormResource.class);
        rc.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, Level.WARNING.getName());

        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
            server.start();

            System.out.println(String.format(
                    "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI, BASE_URI));

            System.in.read();
            server.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
