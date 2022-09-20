package com.spring.core.ckp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_details")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> listPosts;


    public User(Integer id, String name, LocalDate birthDate, List<Post> listPosts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.listPosts = listPosts;
    }

    public User() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public List<Post> getListPosts() {
        return this.listPosts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @JsonIgnore
    public void setListPosts(List<Post> listPosts) {
        this.listPosts = listPosts;
    }


    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", birthDate=" + this.getBirthDate() + ", listPosts=" + this.getListPosts() + ")";
    }
}
