package com.codeup.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "endorsements")
public class Endorsement {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @Column(nullable = false)
    private byte value;


    public Endorsement(byte value) {
        this.value = value;
    }

    public Endorsement(long id, byte value) {
        this.id = id;
        this.value = value;
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
}
