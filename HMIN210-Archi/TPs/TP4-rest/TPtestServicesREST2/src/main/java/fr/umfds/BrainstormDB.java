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

    public BrainstormDB(ArrayList<Brainstorm> brainstorms) {
        this.brainstorms = brainstorms;
    }

    public static ArrayList<Brainstorm> getBrainstorms() {
        return brainstorms;
    }

    public ArrayList<Brainstorm> getBrainstorms2() {
        return brainstorms;
    }
}