package com.codeup.pikes.models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Ticket(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
