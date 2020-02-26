package com.codeup.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

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

    @Transient
    private Integer rating;

    @Column(length = 200)
    private String query;

    @Column(name = "file_path")
    private String filePath;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Endorsement> endorsements = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "reportCategory",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "report_id")}
    )
    @JsonBackReference
    private List<Category> categories = new ArrayList<>();

    @Transient
    private List<String> JSONcategories = new ArrayList<>();

    public void makeJsonCats() {
        List<String> temp = new ArrayList<>();
        for (Category rep: this.categories) {
            temp.add(rep.getName());
        }
        this.JSONcategories = temp;
    }

    @Column(nullable = false)
    private String dateEntered;

    @Column()
    private String dateUpdated;

    @Column(name = "positive_end")
    private int positiveEndorsementCount;

    @Column(name = "negative_end")
    private int negativeEndorsementCount;

    public Report() {
    }
    //! This constructor is used for creating a report in the geocode
    public Report(
            int waterInches,
            String description
    ){
        this.waterInches = waterInches;
        this.description = description;
        this.dateEntered = formatDate();
        this.positiveEndorsementCount = 0;
        this.negativeEndorsementCount = 0;
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
        this.dateEntered = formatDate();
        this.positiveEndorsementCount = 0;
        this.negativeEndorsementCount = 0;
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
        this.dateEntered = formatDate();
        this.positiveEndorsementCount = 0;
        this.negativeEndorsementCount = 0;
    }

    @PrePersist
    public void init(){
        this.dateEntered = formatDate();
    }

    @PreUpdate
    public void onUpdate(){
        this.dateUpdated = formatDate();
    }

    //! FORMAT NEW DATE()
    private String formatDate(){
        String[] dateSplit = new Date().toString().split(" ");
        String formatedDate = String.format("%s %s %s %s",
                dateSplit[0], dateSplit[1], dateSplit[2], dateSplit[dateSplit.length-1]);
        return formatedDate;
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

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered() {
        this.dateEntered = formatDate();
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated() {
        formatDate();
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

    public void addCategory(Category category){
        categories.add(category);
        System.out.println("category added");
    }

    // Returns rating and if null will use makeRating() to generate one.
    public int getRating(){
        if (this.rating == null){
            return this.makeRating();
        }
        return this.getRating();
    }

    // Sets rating based on endorsements, returns 0 if null or no endorsements are available
    private int makeRating(){
        int rating = 0;
        if ( !(this.endorsements == null || this.endorsements.size() == 0) ) {
            for (int i = 0; i < this.endorsements.size(); i++) {
                rating += this.endorsements.get(i).getValue();
            }
        }
        this.rating = rating;
        return rating;
    }

    public void setRating(){
        makeRating();
    }
    public void setRating(int n) {
        this.rating = n;
    }
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
//
    public int getPositiveEndorsementCount() {
        return positiveEndorsementCount;
    }

    public void setPositiveEndorsementCount(int positiveEndorsementCount) {
        this.positiveEndorsementCount = positiveEndorsementCount;
    }

    public int getNegativeEndorsementCount() {
        return negativeEndorsementCount;
    }

    public void setNegativeEndorsementCount(int negativeEndorsementCount) {
        this.negativeEndorsementCount = negativeEndorsementCount;
    }

    public List<String> getJSONcategories() {
        return JSONcategories;
    }

    public void setJSONcategories(List<String> JSONcategories) {
        this.JSONcategories = JSONcategories;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", zipcode=" + zipcode +
                ", waterInches=" + waterInches +
                ", description='" + description + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", endorsements=" + endorsements +
                ", user=" + user +
                ", categories=" + categories +
                ", dateEntered=" + dateEntered +
                ", dateUpdated=" + dateUpdated +
                '}';
    }


}
