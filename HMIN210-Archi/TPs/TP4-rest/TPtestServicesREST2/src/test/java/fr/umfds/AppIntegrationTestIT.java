package fr.umfds;

import org.glassfish.jersey.client.JerseyWebTarget;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class AppIntegrationTestIT extends JerseyTest {

    protected Application configure() {

        ResourceConfig resourceConfig = new ResourceConfig(BrainstormResource.class);
        resourceConfig.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, Level.WARNING.getName());

        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                ArrayList<Brainstorm> l = new ArrayList<>(Arrays.asList(
                        new Brainstorm(2, "bs2", new ArrayList<>()),
                        new Brainstorm(1, "bs1", new ArrayList<>()),
                        new Brainstorm(3, "bs3", new ArrayList<>())
                ));
                BrainstormDB brainstormDBMock = Mockito.mock(BrainstormDB.class);
                Mockito.when(brainstormDBMock.getBrainstorms2()).thenReturn(l);
                bind(brainstormDBMock).to(BrainstormDB.class);
            }
        });
        return resourceConfig;
    }

    @Test
    public void testGetBrainstorms2() {
        // Given
        int expectedSize = 3;

        // When
        Response response = this.target("/brainstorms").request(MediaType.APPLICATION_JSON_TYPE).get();

        // Then
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(), "Http Response should be 200: ");
        List<Brainstorm> readEntities = response.readEntity(new GenericType<List<Brainstorm>>() {});
        Assertions.assertNotNull(readEntities);
        int actualSize = readEntities.size();
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertTrue(readEntities.stream().anyMatch(current -> current.getId() == 1));
    }


//    @Test
//    public void testGetBrainstorms() {
//       // Given
//        Client client = ClientBuilder.newClient();
//
//        // Given
//        int expectedSize = 3;
//
//        // When
//        WebTarget target = client.target("http://localhost:8080/rest/brainstorms");
//        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
//
//        // Then
//        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
//                "Http Response should be 200: ");
//        List<Brainstorm> readEntities = response.readEntity(new GenericType<>() {});
//        Assertions.assertNotNull(readEntities);
//        Assertions.assertEquals(expectedSize, readEntities.size());
//        Assertions.assertTrue(readEntities.stream().anyMatch(current -> current.getId()==1));
//    }
}
