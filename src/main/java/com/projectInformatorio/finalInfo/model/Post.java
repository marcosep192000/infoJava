package com.projectInformatorio.finalInfo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id ;
    private String title;
    private String description;
    private String bodyNews;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    User user;

    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    private List<Coment> coment= new ArrayList<>();

    private final LocalDate creationDate = LocalDate.now();
    private boolean published;





    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBodyNews() {
        return bodyNews;
    }
    public void setBodyNews(String bodyNews) {
        this.bodyNews = bodyNews;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public boolean isPublished() {
        return published;
    }
    public void setPublished(boolean published) {
        this.published = published;
    }


    public List<Coment> getComent() {
        return coment;
    }

    public void setComent(List<Coment> coment) {
        this.coment = coment;
    }


    public void addComent(Coment coment) {
        this.coment.add(coment);
        coment.setPost(this);
    }

}
