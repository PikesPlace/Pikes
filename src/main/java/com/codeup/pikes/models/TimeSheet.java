package com.codeup.pikes.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "timeSheets")
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    @Column
    private java.util.Date thisDate;

    @Column
    private Time startTime;

    @Column
    private Time timeOut;

    @Column
    private Time timeIn;

    @Column
    private Time endTime;

    public TimeSheet(){};

    public TimeSheet (long id, User user, Date thisDate, Time startTime, Time timeOut, Time timeIn, Time endTime){
        this.id = id;
        this.user = user;
        this.thisDate = thisDate;
        this.startTime = startTime;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
        this.endTime = endTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public java.util.Date getThisDate() {
        return thisDate;
    }

    public void setThisDate(java.util.Date thisDate) {
        this.thisDate = thisDate;
    }
}
