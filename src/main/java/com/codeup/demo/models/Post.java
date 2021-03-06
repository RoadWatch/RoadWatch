package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Body is required")
    private String body;

    @Column(nullable = false)
    private String date;

    //!I'm not sure we need this
    @Column(nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonManagedReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonBackReference
    private List<Comment> comments;

    public Post(){
        this.date = formatDate();
    }

    public Post(String title, String body, Long user_id) {
        this.user_id = user_id;
        this.title = title;
        this.body = body;
        this.date = formatDate();
    }

    public Post(Long id, String title, String body, Long user_id, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
        this.date = formatDate();
    }

    public Post(String title, String body, Long user_id, Date date) {
        this.user_id = user_id;
        this.title = title;
        this.body = body;
        this.date = formatDate();
    }

    public Post(Long id, String title, String body, User user) {
        this.id = id;
        this.user = user;
        this.user_id = this.user.getId();
        this.title = title;
        this.body = body;
    }
    //! get top three comments
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

    //! FORMAT NEW DATE()
    private String formatDate(){
        String[] dateSplit = new java.util.Date().toString().split(" ");
        String formatedDate = String.format("%s %s %s %s",
                dateSplit[0], dateSplit[1], dateSplit[2], dateSplit[dateSplit.length-1]);
        return formatedDate;
    }


    //! add comment to list
    public void addComment(Comment comment){
        comments.add(comment);
        System.out.println("comment added");
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
