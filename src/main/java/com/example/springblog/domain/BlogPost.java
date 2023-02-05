package com.example.springblog.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;

    @Column(name = "created")
    private String created;
    @Column(name = "update")
    private String updated;

    @Column(name = "image")
    private String image;

    public BlogPost() {

    }

    public BlogPost(long id, String title, String text, String created, String updated) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.created = created;
        this.updated = updated;
    }

}
