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

//    @ManyToMany(mappedBy = "jobTypes")
//    private List<Ticket> ticketJobType;

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
//
//    public List<Ticket> getTicketJobType() {
//        return ticketJobType;
//    }
//
//    public void setTicketJobType(List<Ticket> ticketJobType) {
//        this.ticketJobType = ticketJobType;
//    }
}
