package models;

import javax.persistence.*;

@Entity
@Table(name="journalists")
public class Journalist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="journalist_name")
    private String journalistName;

    //TODO Add Articles Array

    public Journalist(String journalistName) {
        this.journalistName = journalistName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJournalistName() {
        return journalistName;
    }

    public void setJournalistName(String journalistName) {
        this.journalistName = journalistName;
    }
}
