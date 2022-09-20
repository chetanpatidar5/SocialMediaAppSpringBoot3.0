package com.spring.core.ckp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "post_details")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;


    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Post() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString() {
        return "Post(id=" + this.getId() + ", description=" + this.getDescription() + ", user=" + this.getUser() + ")";
    }

    public User getUser() {
        return this.user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }
}
