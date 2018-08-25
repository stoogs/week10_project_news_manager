package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")



public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private int id;

    @Column(name = "location_name")
        private String locationName;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
        private List<Article> locationArticles;

    public Location(String locationName) {
        this.id = id;
        this.locationName = locationName;
//    this.locationArticles = new List<Article>();
    }

    public Location() {
    }

    public int getId() {
            return id;
        }

    public void setId(int id) {
            this.id = id;
        }

    public String getLocationName() {
            return locationName;
        }

    public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

}
