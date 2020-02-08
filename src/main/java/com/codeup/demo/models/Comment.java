package com.codeup.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long post_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    @NotBlank(message = "Body of comment is required")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
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
        this.user_id = this.user.getId();
        this.post_id = this.post.getId();
    }

    public Comment(Long user_id, String text) {
        this.user_id = user_id;
        this.body = text;
    }

    public Comment(Long id, Long user_id, String text) {
        this.id = id;
        this.user_id = user_id;
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

    public Long getPost_id() {
        return post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getBody() {
        return body;
    }
}