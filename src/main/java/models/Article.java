package models;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

//    TODO: add many to one - journalist
    @ManyToOne
    @JoinColumn(name = "journalist_id", nullable = false)
    private Journalist journalist;

    //    TODO: add many to one - category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    //    TODO: add many to one - location
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "headline")
    private String headline;

    @Column(name = "content")
    private String content;

    @Column(name = "time_stamp")
    private Date timeStamp;

    public Article(String title, Journalist journalist, Category category, Location location, String headline, String content, Date timeStamp) {
        this.id = id;
        this.title = title;
        this.journalist = journalist;
        this.category = category;
        this.location = location;
        this.headline = headline;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
