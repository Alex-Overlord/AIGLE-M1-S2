package fr.umfds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "brainstorm")
@XmlAccessorType(XmlAccessType.FIELD)
public class Brainstorm {
    private int id;
    private String name;
    private ArrayList<Idea> ideas;

    public Brainstorm() {
        super();
    }

    public Brainstorm(int id, String name, ArrayList<Idea> ideas) {
        super();
        this.id = id;
        this.name = name;
        this.ideas = ideas;
    }

    public int compareTo(Brainstorm bs) {
        return getName().compareTo(bs.getName());
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
