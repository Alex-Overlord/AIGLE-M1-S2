package fr.umfds;

import com.sun.research.ws.wadl.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

public class AppIntegrationTest extends JerseyTest {
    
    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig(BrainstormResource.class);
        return resourceConfig;
    }
}
