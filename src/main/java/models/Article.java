package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "journalist_id", nullable = false)
    private Journalist journalist;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "headline", columnDefinition = "TEXT")
    private String headline;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp")
    private GregorianCalendar timeStamp;

    @Column(name = "counter")
    private int counter;

    public Article() {
    }

    public Article(String title, Journalist journalist, Category category, Location location, GregorianCalendar timeStamp, String headline, String content) {
        this.id = id;
        this.title = title;
        this.journalist = journalist;
        this.category = category;
        this.location = location;
        this.headline = headline;
        this.content = content;
        this.timeStamp = timeStamp;
        this.counter = counter;
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

    public GregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(GregorianCalendar timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

