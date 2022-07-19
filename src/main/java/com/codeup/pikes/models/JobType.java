package com.codeup.pikes.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "JobTypes")
public class JobType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    public JobType (){};

    public JobType (long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
