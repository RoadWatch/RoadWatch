package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reports")
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Zipcode is required")
    private int zipcode;

    @Column(name = "water_inches")
    private int waterInches;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Description is required")
    private String description;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "Longitude is required")
    private String longitude;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "Latitude is required")
    private String latitude;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Endorsement> endorsements;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reportCategory",
            joinColumns = {@JoinColumn(name = "report_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories = new ArrayList<>();

    @Column(nullable = false)
    @NotBlank
    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date dateEntered;

    @Column(nullable = false)
    @NotBlank
    @JsonFormat(pattern = "mm-dd-yyyy")
    private Date dateUpdated;


    public Report() {
    }

    public Report(
            int zipcode,
            int waterInches,
            String longitude,
            String latitude,
            String description,
            User user
    ){

        this.zipcode = zipcode;
        this.waterInches = waterInches;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.user = user;
    }

    public Report(
            long id,
            int zipcode,
            int waterInches,
            String longitude,
            String latitude,
            String description,
            User user
    ){
        this.id = id;
        this.zipcode = zipcode;
        this.waterInches = waterInches;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.user = user;
    }


    @PrePersist
    public void init(){
        this.dateEntered = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.dateUpdated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getWaterInches() {
        return waterInches;
    }

    public void setWaterInches(int waterInches) {
        this.waterInches = waterInches;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<Endorsement> getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(List<Endorsement> endorsements) {
        this.endorsements = endorsements;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
