package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Ticket;
import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String ticket1(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", new Ticket());
        model.addAttribute("businesses", businessDao.findAll());
        return "ticket/ticket1";
    }

    @PostMapping("/ticketStart")
    public String ticketStart(@ModelAttribute Ticket ticket){
        ticketDao.save(ticket);
        return "ticket/ticket2";
    }





}
