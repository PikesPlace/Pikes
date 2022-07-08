package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Location;
import com.codeup.pikes.models.Ticket;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    Cancel ticket
    @PostMapping("/cancelTicket")
    public String cancelTicket(@RequestParam("cancelId") Long id){
        ticketDao.deleteById(id);
        return "/home";
    }

//    Page 1
    @GetMapping("/ticket1")
    public String ticket1(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", new Ticket());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("types", jobTypeDao.findAll());
        return "ticket/ticket1";
    }

    @PostMapping("/ticketStart")
    public String ticketStart(@ModelAttribute Ticket ticket, @RequestParam("loc") String location, @RequestParam("type") String type, @RequestParam("user") Long id){
        ticket.setLocation(locationDao.findByName(location));
        ticket.setBusiness(locationDao.findByName(location).getBusiness());
        ticket.setType(type);
        ticket.setUser(userDao.getById(id));
        ticketDao.save(ticket);
        return "redirect:/ticket2/" + ticket.getId();
    }

//    Page 2
    @GetMapping("/ticket2/{id}")
    public String ticket2(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket2";
    }

//    Page 3
    @GetMapping("/ticket3/{id}")
    public String ticket3(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket3";
    }

//    Page 4
    @GetMapping("/ticket4/{id}")
    public String ticket4(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket4";
    }

//    Page 5
    @GetMapping("/ticket5/{id}")
    public String ticket5(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket5";
    }

//    Page 6
    @GetMapping("/ticket6/{id}")
    public String ticket6(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket6";
    }

//    Page 7
    @GetMapping("/ticket7/{id}")
    public String ticket7(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket7";
    }

//    Page 8
    @GetMapping("/ticket8/{id}")
    public String ticket8(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket8";
    }

//    Page 9
    @GetMapping("/ticket9/{id}")
    public String ticket9(Model model, @PathVariable Long id){
        model.addAttribute("ticket", ticketDao.getById(id));
        return "ticket/ticket9";
    }







}
