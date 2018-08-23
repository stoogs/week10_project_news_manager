package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="journalists")
public class Journalist {
    @Id
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
