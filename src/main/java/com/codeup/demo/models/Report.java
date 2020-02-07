package com.codeup.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
}
