package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="journalists")
public class Journalist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="journalist_name")
    private String journalistName;

    @OneToMany(mappedBy = "journalist", fetch = FetchType.LAZY)
    private List<Article> journalistArticles;

    @Column(name="biography", columnDefinition = "TEXT")
    private String biography;

    public Journalist() {
    }

    public Journalist(String journalistName, String biography) {
        this.journalistName = journalistName;
        this.biography = biography;
      //  this.journalistArticles = new List<Article>();
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
