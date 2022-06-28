package com.codeup.pikes.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketNum;

    @OneToOne
    private Location location;

    @OneToOne
    private Business business;

    @Column
    private String date;

    @Column
    private String dateOrdered;

    @Column
    private String dateScheduled;

    @Column
    private String phoneNum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ticket_type", joinColumns = {@JoinColumn(name = "ticket_id")}, inverseJoinColumns = {@JoinColumn(name = "jobType_id")})
    private List<JobType> jobTypes;


    public Ticket(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<JobType> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public Long getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Long ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
