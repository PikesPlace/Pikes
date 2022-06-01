package com.codeup.pikes.controllers;

import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {
    private final TicketRepository ticketDao;
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;

    public TicketController(TicketRepository ticketDao, BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao){
        this.ticketDao = ticketDao;
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
    }

    @GetMapping("/ticket1")
    public String ticket1(){
        return "ticket1";
    }

    @GetMapping("/ticket2")
    public String ticket2(){
        return "ticket2";
    }

    @GetMapping("/ticket3")
    public String ticket3(){
        return "ticket3";
    }



}
