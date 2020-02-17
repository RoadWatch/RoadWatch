package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private int value;

    @Column(nullable = false)
    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "report_id")
    @JsonManagedReference
    private Report report;

    public Endorsement() {
    }

    public Endorsement(byte value) {
        this.value = value;
    }


    public Endorsement(long id, int value) {
        this.id = id;
        this.value = value;
    }

    public Endorsement(int value, User user, Report report) {
        this.value = value;
        this.user = user;
        this.report = report;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
