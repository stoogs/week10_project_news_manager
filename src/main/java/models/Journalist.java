package models;

public class Journalist {
    private int id;
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
