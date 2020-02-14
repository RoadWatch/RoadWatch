package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Body of comment is required")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id",  updatable = false)
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", updatable = false)
    @JsonManagedReference
    private Post post;

    public Post getPost() {
        return this.post;
    }

    public User getUser() {
        return this.user;
    }

    public Comment(){}

    public Comment(String body, User user, Post post) {
        this.body = body;
        this.user = user;
        this.post = post;

    }

    public Comment(Long user_id, String text) {
        this.body = text;
    }

    public Comment(Long id, Long user_id, String text) {
        this.id = id;
        this.body = text;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setIdToNull(){
        this.id = null;
    }
}