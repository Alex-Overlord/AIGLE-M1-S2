package fr.umfds;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;

@Path("/brainstorms")
public class BrainstormResource {

    // retourne les brainstorms en cours, triés par ordre alphabétique sur les noms
    @GET
    public ArrayList<Brainstorm> getBrainstorms() {

        return BrainstormDB.getBrainstorms();
    }
}
