package fr.umfds;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/brainstorms")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class BrainstormResource {

    @Inject
    public BrainstormDB brainstormDB = new BrainstormDB();

    public BrainstormResource() {}

    public BrainstormResource(BrainstormDB brainstormDB) {
        this.brainstormDB = brainstormDB;
    }

    // retourne les brainstorms en cours, triés par ordre alphabétique sur les noms
    @GET
    public ArrayList<Brainstorm> getBrainstorms2() {
        ArrayList<Brainstorm> brainstorms = this.brainstormDB.getBrainstorms2();
        brainstorms.sort(Brainstorm::compareTo);
        return brainstorms;
    }

    public ArrayList<Brainstorm> getBrainstorms() {
        ArrayList<Brainstorm> brainstorms = BrainstormDB.getBrainstorms();
        brainstorms.sort(Brainstorm::compareTo);
        return brainstorms;
    }

    public BrainstormDB getBrainstormDB() {
        return this.brainstormDB;
    }
    public void setBrainstormDB(BrainstormDB brainstormDB) {
        this.brainstormDB = brainstormDB;
    }
}
