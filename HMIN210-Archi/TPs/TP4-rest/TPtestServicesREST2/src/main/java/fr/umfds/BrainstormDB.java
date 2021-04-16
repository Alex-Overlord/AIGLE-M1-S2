package fr.umfds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrainstormDB {
    private static ArrayList<Brainstorm> brainstorms = new ArrayList<>(Arrays.asList(
            new Brainstorm(2, "bs2", new ArrayList<>()),
            new Brainstorm(1, "bs1", new ArrayList<>()),
            new Brainstorm(3, "bs3", new ArrayList<>())
    ));

    public BrainstormDB() {}

    public  BrainstormDB(ArrayList<Brainstorm> brainstormList) {
     brainstorms = brainstormList;
    }

    public static ArrayList<Brainstorm> getBrainstorms() {
        //brainstorms.sort(Brainstorm::compareTo);
        ArrayList<Brainstorm> a = new ArrayList<Brainstorm>();
        a.add(new Brainstorm(2, "bs2", new ArrayList<>()));
        return a ;
    }

    public static void setBrainstorms(ArrayList<Brainstorm> brainstorms) {
        BrainstormDB.brainstorms = brainstorms;
    }

}
