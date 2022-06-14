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
    private Long ticketNum;

    @OneToOne
    private Location location;

    @OneToOne
    private Business business;

    @Column
    private Date date;

    @Column
    private Date dateOrdered;

    @Column
    private Date dateScheduled;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Date getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(Date dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
