package com.codeup.pikes.controllers;

import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;
    private final TicketRepository ticketDao;


    public AdminController(BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao, TicketRepository ticketDao) {
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
        this.ticketDao = ticketDao;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("businesses", businessDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("tickets", ticketDao.findAll());
        return "admin";
    }
}
