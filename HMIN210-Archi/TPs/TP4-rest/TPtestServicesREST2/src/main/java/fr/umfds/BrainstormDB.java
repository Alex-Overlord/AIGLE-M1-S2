package fr.umfds;

import java.util.ArrayList;
import java.util.Arrays;

public class BrainstormDB {
    private static ArrayList<Brainstorm> brainstorms = new ArrayList<>(Arrays.asList(
            new Brainstorm(2, "bs2", new ArrayList<>()),
            new Brainstorm(1, "bs1", new ArrayList<>()),
            new Brainstorm(3, "bs3", new ArrayList<>())
    ));

    public BrainstormDB() {}

    public BrainstormDB(ArrayList<Brainstorm> brainstormList) {
        brainstorms = brainstormList;
    }

    public static ArrayList<Brainstorm> getBrainstorms() {
        brainstorms.sort(Brainstorm::compareTo);
        return brainstorms ;
    }

    public static void setBrainstorms(ArrayList<Brainstorm> brainstorms) {
        BrainstormDB.brainstorms = brainstorms;
    }

}
