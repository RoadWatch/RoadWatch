package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.lang.annotation.Before;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "endorsements")
public class Endorsement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private byte value;

    @Column(nullable = false)
    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user")
    private User User;


    public Endorsement(byte value) {
        this.value = value;
    }


    public Endorsement(long id, byte value) {
        this.id = id;
        this.value = value;
    }

    @PrePersist
    public void addTimeStamp(){
        this.date = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
