package fr.umfds;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/brainstorms")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class BrainstormResource {

    // retourne les brainstorms en cours, triés par ordre alphabétique sur les noms
    @GET
    public ArrayList<Brainstorm> getBrainstorms() {
        return BrainstormDB.getBrainstorms();
    }
}
