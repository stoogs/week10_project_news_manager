package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Article> categoryArticles;

    public Category() {
    }

    public Category(String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryArticles = new ArrayList<>();
    }

        public int getId() {
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName){
            this.categoryName = categoryName;
        }

        public List<Article> getCategoryArticles() {
            return categoryArticles;
        }

        public void setCategoryArticles(List<Article> categoryArticles) {
            this.categoryArticles = categoryArticles;
        }

    }


