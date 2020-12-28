package com.projectInformatorio.finalInfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Size(max=30)
    private String name;
    @Size(max=30)
    private String surname;
    @Column(unique = true)
    @Email
    private String email;
    @JsonIgnore
    private String password;
    private final LocalDate creationDate = LocalDate.now();
    @Size(max=50)
    private String city;
    @Size(max=50)
    private String state;
    @Size(max=50)
    private String country;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Post> post= new ArrayList<>();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void addPost(Post post) {
        this.post.add(post);
        post.setUser(this);
    }

}
