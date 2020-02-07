package com.codeup.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post(){}

    public Post(String title, String body, Long user_id) {
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body, Long user_id) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.user = user;
        this.user_id = this.user.getId();
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body, User user) {
        this.id = id;
        this.user = user;
        this.user_id = this.user.getId();
        this.title = title;
        this.body = body;
    }

    public List<Comment> getTopComments(){
        List<Comment> topComments = new ArrayList<>();
        List<Comment> re = this.comments;
        try {
            for (int i = 0; i < 3 && i < re.size(); i++) {
                topComments.add(re.get(i));
            }
        } catch (Exception ignored){
            return topComments;
        }
        return topComments;
    }

    public void setUser(User user) {
        this.user = user;
        this.user_id = user.getId();
    }

    public User getUser() {
        return this.user;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
