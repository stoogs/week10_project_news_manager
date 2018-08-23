package models;

public class Article {
    private int id;
    private String title;
    private Journalist journalist;
    private Category category;
    private String headline;
    private String content;
    private DateFormater timeStamp;

    public Article(String title, Journalist journalist, Category category, String headline, String content, DateFormater timeStamp) {
        this.id = id;
        this.title = title;
        this.journalist = journalist;
        this.category = category;
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

    public DateFormater getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(DateFormater timeStamp) {
        this.timeStamp = timeStamp;
    }
}
