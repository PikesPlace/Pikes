package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Ticket;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {
    private final TicketRepository ticketDao;
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;
    private final JobTypeRepository jobTypeDao;

    public TicketController(TicketRepository ticketDao, BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao, JobTypeRepository jobTypeDao){
        this.ticketDao = ticketDao;
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
        this.jobTypeDao = jobTypeDao;
    }

    @GetMapping("/ticket1")
    public String ticket1(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", new Ticket());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("types", jobTypeDao.findAll());
        return "ticket/ticket1";
    }

    @PostMapping("/ticketStart")
    public String ticketStart(@ModelAttribute Ticket ticket, @RequestParam("loc") String location, @RequestParam("type") String type, @RequestParam("user") String username){
        ticket.setLocation(locationDao.findByName(location));
        ticket.setBusiness(locationDao.findByName(location).getBusiness());
        ticket.setType(type);
        ticket.setUser(userDao.findByUsername(username));
        ticketDao.save(ticket);
        return "redirect:/ticket2/" + ticket.getId();
    }

    @GetMapping("/ticket2/{id}")
    public String ticket2(Model model){

        return "ticket/ticket2";
    }





}
