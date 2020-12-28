package com.projectInformatorio.finalInfo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Coment{

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private final LocalDate creationDate = LocalDate.now();
    private  String Coment ;

    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private
    Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getComent() {
        return Coment;
    }

    public void setComent(String coment) {
        Coment = coment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
