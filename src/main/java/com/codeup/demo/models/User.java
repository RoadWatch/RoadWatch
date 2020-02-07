package com.codeup.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true, length = 25)
    @NotBlank(message = "Username is required")
    private String username;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "Email is required")
    private String email;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Last name is required")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private List<Report> reports;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endorsment")
    private List<Endorsement> endorsments;



    public User() {
    }

    public User(
            String username,
            String email,
            String password,
            String firstName,
            String lastName,
            List<Report> reports
    ){
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reports = reports;
    }

    public User(
            long id,
            String username,
            String email,
            String password,
            String firstName,
            String lastName
    ){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
