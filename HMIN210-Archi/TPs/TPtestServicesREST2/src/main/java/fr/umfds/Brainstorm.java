package fr.umfds;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "brainstorm")
public class Brainstorm {
    private int id;
    private String name;
    private ArrayList<Idea> ideas;

    public Brainstorm() { }

    public Brainstorm(int id, String name, ArrayList<Idea> ideas) {
        this.id = id;
        this.name = name;
        this.ideas = ideas;
    }

    public int compareTo(Brainstorm bs) {
        String bs_name = bs.getName();
        return getName().compareTo(bs_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(ArrayList<Idea> ideas) {
        this.ideas = ideas;
    }
}
