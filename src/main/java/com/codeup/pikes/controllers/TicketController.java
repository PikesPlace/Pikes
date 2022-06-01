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

    @GetMapping("/ticket4")
    public String ticket4(){
        return "ticket4";
    }

    @GetMapping("/ticket5")
    public String ticket5(){
        return "ticket5";
    }

    @GetMapping("/ticket6")
    public String ticket6(){
        return "ticket6";
    }

    @GetMapping("/ticket7")
    public String ticket7(){
        return "ticket7";
    }

    @GetMapping("/ticket8")
    public String ticket8(){
        return "ticket8";
    }

    @GetMapping("/ticket9")
    public String ticket9(){
        return "ticket9";
    }


}
